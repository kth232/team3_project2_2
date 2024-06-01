package org.choongang.start.startmain;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
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
    public void change(Menu menu) {
        ControllerLocator startlocator = StartControllerLocator.getInstance();

        StartMenu startMenu = (StartMenu) menu;
        Controller controller = null;
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
