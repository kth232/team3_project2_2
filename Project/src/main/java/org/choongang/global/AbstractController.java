package org.choongang.global;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class AbstractController implements Controller {

    protected Scanner sc;
    public AbstractController() {
        sc = new Scanner(System.in);
    }

    /**
     * 상단 공통 출력 부분
     */
    public void common() {

    }


    public void prompt() {


    }


    @Override
    public final void run() {
        common();
        show();
        prompt();
    }



    private void change() {
//        Menu menu = null;
//        switch(menuNo) {
//            case 1: menu = Menu.JOIN; break; // 회원가입
//            case 2: menu = Menu.LOGIN; break; // 로그인
//            default: menu = Menu.MAIN; // 메인 메뉴
//        }

        // 메뉴 컨트롤러 변경 처리 - Router
        //MainRouter.getInstance().change(menu);
    }
}