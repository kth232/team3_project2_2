package org.choongang.grades;

import org.choongang.grades.constants.GradesMenu;
import org.choongang.grades.controllers.BackController;
import org.choongang.grades.controllers.SelectController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

public class GradesAdminControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private GradesAdminControllerLocator(){}

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new GradesAdminControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null){
            if(controller != null){
                return controller;
            }
        }

        if(menu instanceof GradesMenu){
            GradesMenu gradesMenu = (GradesMenu) menu;
            switch (gradesMenu){
                case SELECT : controller = new SelectController(); break;
                default : controller = new BackController();
            }
        }

        return null;
    }
}
