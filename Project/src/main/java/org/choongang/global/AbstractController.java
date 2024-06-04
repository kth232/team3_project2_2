package org.choongang.global;


import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.template.Templates;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller {

    protected Scanner sc; //스캐너 정의
    protected Menu menu;
    public AbstractController() {
        sc = new Scanner(System.in);
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {
        System.out.print(Templates.getInstance().doubleLine());
        System.out.println("학생관리 프로그램 ver1.0");
        System.out.print(Templates.getInstance().doubleLine());
    }

    /**
     * 입력 항목
     *  - 문자: q, exit, quit - 종료
     *  - 숫자: 메뉴 항목
     */
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
            System.out.println("메뉴는 [숫자]로 입력하세요.");
        }
    }

    /**
     * 입력과 검증을 함께 진행
     *
     * @param message : 항목 메세지
     * @param predicate : 판별식
     * @return
     */
    protected String promptWithValidation(String message, Predicate<String> predicate) {
        String str = null;
        do {
            System.out.print(message);
            str = sc.nextLine();
        } while(!predicate.test(str));

        return str;
    }

    /**
     * 템플릿 메서드 패턴 : 특정 절차가 고정되어 있는 경우
     *
     */
    @Override
    public final void run() {
        common();
        show();
        prompt();
    }



    private void change(int menuNo) {
        StartMenu startmenu = null;
        switch(menuNo) {
            case 1: startmenu = StartMenu.JOIN; break; // 회원가입
            case 2: startmenu = StartMenu.LOGIN; break; // 로그인
            default: startmenu = StartMenu.STARTMAIN; break; // 메인 메뉴
      }

        // 메뉴 컨트롤러 변경 처리 - Router
        StartMainRouter.getInstance().change(startmenu);
    }


}
