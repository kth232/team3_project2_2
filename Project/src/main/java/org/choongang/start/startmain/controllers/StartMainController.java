package org.choongang.start.startmain.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.template.Templates;

import java.util.Scanner;

public class StartMainController extends AbstractController {

    @Override
    public void show() {
        //System.out.println("메인템플릿 출력");
        Templates.getInstance().render(StartMenu.STARTMAIN);
        //1번 회원가입, 2번 로그인 선택하는 템플릿
    }

}
