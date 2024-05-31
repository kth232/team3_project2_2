package org.choongang.admin;


import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.controllers.JoinController;
import org.choongang.start.controllers.LoginController;

public class AdminControllerLocator extends AbstractControllerLocator {

    private static ControllerLocator instance;
    private AdminControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new AdminControllerLocator();
        }
        return instance;
    }
    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        //예시본
//        if(controller != null) {
//            return controller;
//        }
//        StartMenu startMenu = (StartMenu) menu;
//
//        switch(startMenu) {
//            case JOIN : controller = new JoinController(); break;
//            default: controller = new LoginController(); break;
//        }
        controllers.put(menu,controller);
        return controller;
    }
}
