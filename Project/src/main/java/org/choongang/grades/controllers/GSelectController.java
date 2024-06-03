package org.choongang.grades.controllers;

import org.choongang.global.AbstractController;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.template.Templates;

//반 선택
public class GSelectController extends AbstractController {

    @Override
    public void show() {

        Templates.getInstance().render(GradeMenu.SELECT, () -> {
            return "1. 1반\n2. 2반\n";
        });

    }
    @Override
    public void prompt() {
        while(true) {
            System.out.print("관리할 반 선택: ");
            String classNo = sc.nextLine();

        }
    }



}
