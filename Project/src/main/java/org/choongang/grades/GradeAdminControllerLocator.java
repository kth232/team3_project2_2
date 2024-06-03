package org.choongang.grades;

import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.controllers.GSelectController;

public class GradeAdminControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private GradeAdminControllerLocator(){}

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new GradeAdminControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);

        if(controller != null){
            return controller;
        }

        if(menu instanceof GradeMenu){
            GradeMenu gradeMenu = (GradeMenu) menu;
            switch (gradeMenu){
                case SELECTCLASS: controller = new GSelectController(); break;
            }
        } else {
            controller = new AdminMainController();
        }

        return controller;
    }
}
