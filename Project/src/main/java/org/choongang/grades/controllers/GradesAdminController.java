package org.choongang.grades.controllers;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.grades.GradesAdminControllerLocator;
import org.choongang.grades.constants.GradesMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.template.Templates;

public class GradesAdminController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(AdminMenu.GRADE);
    }

    @Override
    public void prompt() {
        while(true){
            System.out.println("메뉴 선택");
            String menu = sc.nextLine();
            try{
                int m = Integer.parseInt(menu);
                if(m >= 1 && m <= 4){
                    change(m);
                    break;
                }
            } catch(Exception e){
                System.out.println("메뉴 1, 2 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo){
        ControllerLocator locator = GradesAdminControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo){
            case 1:
                controller = locator.find(GradesMenu.SELECT);
            default:
                controller = locator.find(GradesMenu.BACK);
                return;
        }

//        if(controller != null){
//            controller.run();
//        }

    }
}
