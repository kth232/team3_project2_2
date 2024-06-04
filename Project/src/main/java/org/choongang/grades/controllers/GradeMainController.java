package org.choongang.grades.controllers;

import org.choongang.global.AbstractController;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.template.Templates;

public class GradeMainController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(GradeMenu.CLASSCHOICE);
    }

    @Override
    public void prompt() {

    }
}
