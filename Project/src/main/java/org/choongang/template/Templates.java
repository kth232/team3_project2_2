package org.choongang.template;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.Menu;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.start.constants.StartMenu;
import org.choongang.template.admin.*;
import org.choongang.template.lecture.AddLectureTpl;
import org.choongang.template.lecture.ChoiceLectureTpl;
import org.choongang.template.lecture.ModLectureTpl;
import org.choongang.template.lecture.SubLectureTpl;
import org.choongang.template.start.JoinTpl;
import org.choongang.template.start.LoginTpl;
import org.choongang.template.start.StartMainTpl;


import java.util.HashMap;
import java.util.Map;

public class Templates {
    private static Templates instance;
    private Map<Menu, Template> tpls;

    private Templates() {
        tpls = new HashMap<>();
    }

    public static Templates getInstance() {
        if (instance == null) {
            instance = new Templates();
        }

        return instance;
    }

    public void render(Menu menu) {

        System.out.println(find(menu).getTpl());
    }

    public Template find(Menu menu) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        if (menu instanceof AdminMenu adminMenu) {
            switch(adminMenu) {
                case STUDENT: tpl = new StudentTpl(); break;
                case ATTENDANCE: tpl = new AttendanceTpl(); break;
                case GRADE: tpl = new GradeTpl(); break;
                case LECTURE: tpl = new LectureTpl(); break;

                default: tpl = new AdminMainTpl();
                //case ADMINMAIN: tpl = new AdminMainTpl(); break; 잠시보류 중
            }
        } else if(menu instanceof StartMenu startMenu) {
            switch (startMenu) {
                case JOIN: tpl = new JoinTpl(); break;
                case LOGIN: tpl = new LoginTpl(); break;

                default: tpl = new StartMainTpl();
            }
        } else {
            LectureMenu lectureMenu = (LectureMenu) menu;
            switch (lectureMenu) {
                case LECTUREMAIN: tpl = new LectureTpl(); break;
                case CLASSCHOICE: tpl = new ChoiceLectureTpl(); break;
                case BACK: tpl = new AdminMainTpl(); break;
                case LECTURESUBMAIN: tpl = new SubLectureTpl(); break;
                case ADDLECTURE: tpl = new AddLectureTpl(); break;
                case MODLECTURE: tpl = new ModLectureTpl(); break;

                default: tpl = new LectureTpl();
            }
        }

        tpls.put(menu, tpl);

        return tpl;
    }

    public String line() {
        return "-----------------------------------\n";
    }

    public String doubleLine() {
        return "===================================\n";
    }
}
