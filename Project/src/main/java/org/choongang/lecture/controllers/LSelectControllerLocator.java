package org.choongang.lecture.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;

public class LSelectControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private LSelectControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new LSelectControllerLocator();
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
