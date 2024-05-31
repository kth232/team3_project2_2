package org.choongang.start.controllers;

import org.choongang.global.AbstractController;

public class JoinController extends AbstractController {
    @Override
    public void show() {
        System.out.println("JoinTpl화면");//Templates.getInstance().render(StartMenu.Join);
    }
}
