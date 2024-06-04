package org.choongang.start.startmain;

import org.choongang.global.*;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.controllers.StartMainController;

public class StartMainRouter implements Router, Startable {
    private static Router instance;
    private StartMainRouter(){}

    public static Router getInstance(){
        if(instance == null){
            instance = new StartMainRouter();
        }
        return instance;
    }

    @Override
    public void change(Menu menu) {
        ControllerLocator startlocator = StartControllerLocator.getInstance();

        Controller controller = null;
        StartMenu startMenu = (StartMenu) menu;

        switch (startMenu){
            case JOIN: controller = startlocator.find(StartMenu.JOIN); break;
            case LOGIN: controller = startlocator.find(StartMenu.LOGIN); break;
            default: controller = new StartMainController(); break;
        }
        controller.run(); // common(), show(), prompt()
    }

    @Override
    public void start() {
        while (true){
            change(StartMenu.STARTMAIN); //첫 화면은 StartMain 컨트롤러 출력 화면
        }
    }
}
