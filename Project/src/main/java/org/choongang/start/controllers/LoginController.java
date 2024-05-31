package org.choongang.start.controllers;

import org.choongang.global.AbstractController;

public class LoginController extends AbstractController {
    @Override
    public void show() {
        System.out.println("LoginTpl화면");//Templates.getInstance().render(StartMenu.LOGIN);
    }
}
