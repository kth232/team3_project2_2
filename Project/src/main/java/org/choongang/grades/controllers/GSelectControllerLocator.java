package org.choongang.grades.controllers;

import org.choongang.admin.controllers.GradeAdminController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.grades.constants.GradeMenu;

public class GSelectControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private GSelectControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new GSelectControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

        if(menu instanceof GradeMenu){
            GradeMenu gradeMenu = (GradeMenu) menu;
            switch(gradeMenu) {
                case GETGRADE : controller = new GetGradeController(); break;
                case MODGRADE : controller = new ModGradeController(); break;
                default : controller = new GSelectController(); break;
            }
        } else {
            controller = new GradeAdminController();
        }
        controller.setMenu(menu);
        controllers.put(menu, controller);
        return controller;
    }
}
