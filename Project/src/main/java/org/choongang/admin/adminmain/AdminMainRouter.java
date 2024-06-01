package org.choongang.admin.adminmain;

import org.choongang.admin.AdminControllerLocator;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.start.startmain.controllers.StartMainController;

public class AdminMainRouter implements Router {
    private static Router instance;
    private AdminMainRouter(){}

    public static Router getInstance(){
        if(instance == null){
            instance = new AdminMainRouter();
        }
        return instance;
    }

    @Override
    public void change(Menu menu) {
        ControllerLocator adminlocator = AdminControllerLocator.getInstance();
        AdminMenu adminMenu = (AdminMenu) menu;
        Controller controller = null;
        switch (adminMenu){
            case STUDENT: controller = adminlocator.find(AdminMenu.STUDENT); break;
            case ATTENDANCE: controller = adminlocator.find(AdminMenu.ATTENDANCE); break;
            case GRADE: controller = adminlocator.find(AdminMenu.GRADE); break;
            case LECTURE: controller = adminlocator.find(AdminMenu.LECTURE); break;
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