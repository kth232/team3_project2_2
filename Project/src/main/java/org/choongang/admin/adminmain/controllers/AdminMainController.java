package org.choongang.admin.adminmain.controllers;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.template.Templates;

public class AdminMainController extends AbstractController {
    @Override
    public void show() {
        //System.out.println("AdminMainTpl 화면");
        Templates.getInstance().render(AdminMenu.ADMINMAIN);
    }

    @Override
    public void prompt() {

    }
}
