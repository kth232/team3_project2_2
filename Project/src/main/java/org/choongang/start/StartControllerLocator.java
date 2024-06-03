package org.choongang.start;

import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.*;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.controllers.JoinController;
import org.choongang.start.controllers.LoginController;


public class StartControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private StartControllerLocator() {}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new StartControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

        if(menu instanceof StartMenu){
            StartMenu startMenu = (StartMenu) menu;
            switch(startMenu) {
                case JOIN : controller = new JoinController(); break;
                default: controller = new LoginController(); break;
            }

        }else if(menu instanceof AdminMenu){
            controller = new AdminMainController();
        }
        controllers.put(menu,controller);
        return controller;
    }
}
