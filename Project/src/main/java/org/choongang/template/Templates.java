package org.choongang.template;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.Menu;
import org.choongang.start.constants.StartMenu;
import org.choongang.template.admin.*;
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
                case ADMINMAIN: tpl = new AdminMainTpl(); break;
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
