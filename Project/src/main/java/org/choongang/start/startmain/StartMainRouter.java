package org.choongang.start.startmain;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.start.controllers.JoinController;
import org.choongang.start.startmain.controllers.StartMainController;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;

public class StartMainRouter implements Router {
    private static Router instance;
    private StartMainRouter(){}

    public static Router getInstance(){
        if(instance == null){
            instance = new StartMainRouter();
        }
        return instance;
    }
    @Override
    public void change(StartMenu startMenu) {
        ControllerLocator startlocator = StartControllerLocator.getInstance();

        Controller controller = null;
        switch (startMenu){
            case JOIN: controller = startlocator.find(StartMenu.JOIN); break;
            case LOGIN: controller = startlocator.find(StartMenu.LOGIN); break;
            default: controller = new JoinController(); break; // 바꾸세요
        }
        System.out.println("오류?");
        controller.run();
    }

    @Override
    public void start() {
        while (true){
            change(StartMenu.STARTMAIN);
        }

    }
}
