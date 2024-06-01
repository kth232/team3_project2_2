package org.choongang.admin;


import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.admin.controllers.AttendanceAdminController;
import org.choongang.admin.controllers.GradeAdminController;
import org.choongang.admin.controllers.LectureAdminController;
import org.choongang.admin.controllers.StudentAdminController;
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
        if(controller != null) {
            return controller;
        }

        if(menu instanceof AdminMenu){
            AdminMenu adminMenu = (AdminMenu) menu;
            switch(adminMenu) {
                case GRADE: controller = new GradeAdminController(); break;
                case ATTENDANCE: controller = new AttendanceAdminController(); break;
                case STUDENT: controller = new StudentAdminController(); break;
                case LECTURE: controller = new LectureAdminController(); break;
                default: controller = new AdminMainController(); break;

            }
        }else if(menu instanceof  AdminMenu){

            controller = new AdminMainController();

        }
        controllers.put(menu,controller);
        return controller;
    }
}
