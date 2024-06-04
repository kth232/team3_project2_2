package org.choongang.studentManagement.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

public class StudentControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private StudentControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new StudentControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }
        return  null;
    }

}
