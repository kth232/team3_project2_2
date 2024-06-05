package org.choongang.template;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.Menu;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.start.constants.StartMenu;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.template.admin.*;
import org.choongang.template.lecture.AddLectureTpl;
import org.choongang.template.lecture.ModLectureTpl;
import org.choongang.template.lecture.SubLectureTpl;
import org.choongang.template.start.JoinTpl;
import org.choongang.template.start.LoginTpl;
import org.choongang.template.start.StartMainTpl;
import org.choongang.template.studentManagement.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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
        render(menu, null);
    }

    public void render(Menu menu, Supplier<String> hook) {

        System.out.println(find(menu, hook).getTpl());
    }

    public Template find(Menu menu, Supplier<String> hook) {
        Template tpl = tpls.get(menu);
        if (tpl != null) {
            return tpl;
        }
        if (menu instanceof AdminMenu adminMenu) {
            switch(adminMenu) {
                case STUDENT: tpl = new StudentAdminTpl(); break;
                case ATTENDANCE: tpl = new AttendanceTpl(); break;
                case GRADE: tpl = new GradeTpl(); break;
                case LECTURE: tpl = new LectureTpl(); break;

                default: tpl = new AdminMainTpl();
                //case ADMINMAIN: tpl = new AdminMainTpl(); break; 잠시보류 중
            }

        } else if (menu instanceof GradeMenu) {
            GradeMenu gradeMenu = (GradeMenu) menu;
            switch (gradeMenu) {
                case CLASSCHOICE: tpl = new ClassListTpl(); break;

            }
        } else if (menu instanceof StSMMenu) {
            StSMMenu stSMMenu = (StSMMenu) menu;
            switch (stSMMenu) {
                case ADDSTUDENT:
                    tpl = new StudentAddTpl();
                    break;
                case MODSTUDENT:
                    tpl = new StudentModTpl();
                    break;
                case  LISTSTUDENT502:
                    tpl = new Student502ListTpl();
                    break;
                case LISTSTUDENT503:
                    tpl = new Student503ListTpl();
                    break;
            }
        } else if (menu instanceof LectureMenu) {
            LectureMenu lectureMenu = (LectureMenu) menu;
            switch (lectureMenu) {
                case LECTUREMAIN:
                    tpl = new LectureTpl();
                    break;
                case ADDLECTURE:
                    tpl = new AddLectureTpl();
                    break;
                case MODLECTURE:
                    tpl = new ModLectureTpl();
                    break;
                case LECTURESUBMAIN:
                    tpl = new SubLectureTpl();
                    break;
                case LISTLECTURE:
                    tpl = new ClassListTpl();
                    break;

            }
        } else {
            StartMenu startMenu = (StartMenu) menu;
            switch (startMenu) {
                case JOIN:
                    tpl = new JoinTpl();
                    break;
                case LOGIN:
                    tpl = new LoginTpl();
                    break;

                default:
                    tpl = new StartMainTpl();
            }
        }

        if (hook != null) {
            tpl.addHook(hook);
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
