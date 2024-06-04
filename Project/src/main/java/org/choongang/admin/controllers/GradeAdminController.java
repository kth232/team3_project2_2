package org.choongang.admin.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.grades.GradeMainControllerLocator;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.template.Templates;

public class GradeAdminController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(AdminMenu.GRADE);
    }

    @Override
    public void prompt() {
        while(true){
            System.out.println("메뉴 선택 : ");
            String menu = sc.nextLine();
            try{
                int m = Integer.parseInt(menu);
                if(m >= 1 && m <= 2){
                    change(m);
                    break;
                }
            } catch(Exception e){
                System.out.println("메뉴 1, 2 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo){
        ControllerLocator locator = GradeMainControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo){
            case 1:
                controller = locator.find(GradeMenu.CLASSCHOICE);
                break;
            default:
                AdminMainRouter.getInstance().change(AdminMenu.ADMINMAIN);
        }


         if(controller != null){
              controller.run();
         }

    }
}
