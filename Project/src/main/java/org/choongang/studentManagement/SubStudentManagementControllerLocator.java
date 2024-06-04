package org.choongang.studentManagement;

import org.choongang.admin.controllers.StudentAdminController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.controllers.AddStudentController;
import org.choongang.studentManagement.controllers.ModStudentController;

public class SubStudentManagementControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private SubStudentManagementControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new SubStudentManagementControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

        if(menu instanceof StSMMenu){
            StSMMenu stsmMenu = (StSMMenu) menu;
            switch(stsmMenu) {
                case ADDSTUDENT: controller = new AddStudentController(); break; // 학생 정보 추가하기
                case MODSTUDENT: controller = new ModStudentController(); break; // 학생 정보 수정하기
            }
        } else {
            controller = new StudentAdminController();
        }
        controller.setMenu(menu);
        controllers.put(menu,controller);
        return controller;
    }
}
