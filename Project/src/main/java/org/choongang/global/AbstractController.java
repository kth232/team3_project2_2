package org.choongang.global;

import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.template.Templates;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller {

    protected Scanner sc;
    protected Menu menu;
    public AbstractController() {
        sc = new Scanner(System.in);
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {
        System.out.println("Common 출력");
        System.out.println(Templates.getInstance().doubleLine());
    }


    public void prompt() {
        System.out.print("메뉴 선택: ");
        String menu = sc.nextLine();
        if (menu.equals("q") || menu.equals("quit") || menu.equals("exit")) {
            System.out.println("종료 합니다.");
            System.exit(0); // 0 - 정상 종료, 1 - 비정상 종료
        }

        try {
            int m = Integer.parseInt(menu);
            change(m); // 메뉴 변경
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("메뉴는 숫자로 입력하세요.");
        }
    }

    protected String promptWithValidation(String message, Predicate<String> predicate) {
        String str = null;
        do {
            System.out.print(message);
            str = sc.nextLine();
        } while(!predicate.test(str));

        return str;
    }



    @Override
    public final void run() {
        common();
        show();
        prompt();
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private void change(int menuNo) {
        StartMenu startmenu = null;
        switch(menuNo) {
            case 1: startmenu = StartMenu.JOIN; break; // 회원가입
            case 2: startmenu = StartMenu.LOGIN; break; // 로그인
            default: startmenu = StartMenu.STARTMAIN; // 메인 메뉴
      }

        // 메뉴 컨트롤러 변경 처리 - Router
        StartMainRouter.getInstance().change(startmenu);
    }
}