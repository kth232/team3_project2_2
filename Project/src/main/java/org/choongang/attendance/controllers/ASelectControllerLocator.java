package org.choongang.attendance.controllers;

import org.choongang.global.*;
import org.choongang.grades.controllers.GSelectControllerLocator;

public class ASelectControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private ASelectControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new ASelectControllerLocator()   ;
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

//        if(menu instanceof GradesMenu){
//            GradesMenu gradesMenu = (GradesMenu) menu;
//            switch (gradesMenu){
//                case Class502 :
//            }
//        }
        return  null;
    }


}
