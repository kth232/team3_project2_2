package org.choongang.grades.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

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

//        if(menu instanceof GradesMenu){
//            GradesMenu gradesMenu = (GradesMenu) menu;
//            switch (gradesMenu){
//                case Class502 :
//            }
//        }
        return  null;
    }


}
