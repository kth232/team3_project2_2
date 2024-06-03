package org.choongang.lecture;

import org.choongang.admin.controllers.LectureAdminController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.controllers.AddLectureController;
import org.choongang.lecture.controllers.ModLectureController;
import org.choongang.lecture.controllers.SubLectureController;

public class Sub_Le_AdminControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private Sub_Le_AdminControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new Sub_Le_AdminControllerLocator();
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
                case ADDLECTURE: controller = new AddLectureController(); break; //학급 추가하기
                case MODLECTURE: controller = new ModLectureController(); break; //학급 수정하기

                default: controller = new SubLectureController(); break;

            }
        }else {
            controller = new LectureAdminController();
        }
        controller.setMenu(menu);
        controllers.put(menu,controller);
        return controller;
    }
}
