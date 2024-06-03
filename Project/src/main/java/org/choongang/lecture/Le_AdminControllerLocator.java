package org.choongang.lecture;

import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.controllers.SubLectureController;
import org.choongang.start.startmain.controllers.StartMainController;

public class Le_AdminControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private Le_AdminControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new Le_AdminControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

        if(menu instanceof LectureMenu){
            LectureMenu lectureMenu = (LectureMenu) menu;
            switch(lectureMenu) {
                case SELECTCLASS: controller = new SubLectureController(); break; //반 선택하기
                case BACK: controller = new AdminMainController(); break; //뒤로 가기
            }
        }else {
            controller = new StartMainController();
        }
        controller.setMenu(menu);
        controllers.put(menu,controller);
        return controller;
    }
}
