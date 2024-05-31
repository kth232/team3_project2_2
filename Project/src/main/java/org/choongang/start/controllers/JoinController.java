package org.choongang.start.controllers;

import org.choongang.global.AbstractController;

/**
 * 회원가입 컨트롤러
 */
public class JoinController extends AbstractController {
    @Override
    public void show() {
        System.out.println("JoinTpl화면");//Templates.getInstance().render(StartMenu.Join);
    }
}
