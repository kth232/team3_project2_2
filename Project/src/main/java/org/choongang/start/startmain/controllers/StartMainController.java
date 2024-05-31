package org.choongang.start.startmain.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;

import java.util.Scanner;

public class StartMainController extends AbstractController {

    @Override
    public void show() {
        System.out.println("메인템플릿 출력");//Templates.getInstance().render(StartMenu.STARTMAIN);
    }

    @Override
    public void prompt() {
        Router router = StartMainRouter.getInstance();
        try {
            router.change(StartMenu.STARTMAIN);
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
        } catch (RuntimeException e) {

            System.out.println("error");
        }
    }
}
