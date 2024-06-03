package org.choongang.attendance.services;

import org.choongang.admin.AdminControllerLocator;
import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.controllers.ASelectController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.grades.GradeAdminControllerLocator;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.controllers.GSelectController;

public class AttendanceAdminControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private AttendanceAdminControllerLocator(){}

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new AttendanceAdminControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);

        if(controller != null){
            return controller;
        }

        if(menu instanceof AttendanceMenu){
            AttendanceMenu attendanceMenu = (AttendanceMenu) menu;
            switch (attendanceMenu){
                case SELECT : controller = new ASelectController(); break;
            }
        } else {
            controller = new AdminMainController();
        }

        return controller;
    }
}


