package org.choongang.admin.adminmain.controllers;

import org.choongang.admin.AdminControllerLocator;
import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.template.Templates;

public class AdminMainController extends AbstractController {
    @Override
    public void show() {
        //System.out.println("AdminMainTpl 화면");
        Templates.getInstance().render(AdminMenu.ADMINMAIN);
    }

    //컨트롤러연결을 합시다..
    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 4) {
                    change(m);
                    break;
                }
            } catch (Exception e) {
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo){
        ControllerLocator locator = AdminControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo){
            case 1: controller = locator.find(AdminMenu.STUDENT); break;
            case 2: controller = locator.find(AdminMenu.ATTENDANCE); break;
            case 3: controller = locator.find(AdminMenu.GRADE); break;
            case 4: controller = locator.find(AdminMenu.LECTURE); break;
            default:
                AdminMainRouter.getInstance().change(AdminMenu.ADMINMAIN);
                return;
        }

        if(controller != null){
            controller.run();
        }
    }
}
