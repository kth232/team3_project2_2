package org.choongang.attendance.controllers;

import org.choongang.global.AbstractController;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.template.Templates;

public class ASelectController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(GradeMenu.SELECT, () -> {
            return "1. 502호\n2. 503호\n";
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


