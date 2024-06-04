package org.choongang.grades.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.services.GradeServiceLocator;
import org.choongang.template.Templates;

public class ModGradeController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(GradeMenu.MODGRADE);
    }

    @Override
    public void prompt() {
        //입력 검증 - 입력받은 문자열이 predicate의 조건을 만족하는지 확인

        String studentName = promptWithValidation("학생이름: ", s -> !s.isBlank());
        String ClassNo = promptWithValidation("반이름: ", s -> !s.isBlank());
        String subject = promptWithValidation("과목명: ", s -> !s.isBlank());
        String score = promptWithValidation("점수: ", s -> !s.isBlank());

        SearchGrade form = SearchGrade.builder().build();

        Router router = AdminMainRouter.getInstance();
        try{
            Service service = GradeServiceLocator.getInstance().find(GradeMenu.MODGRADE);
            service.process(form);

            router.change(GradeMenu.GRADEMAIN);
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            router.change(GradeMenu.GRADESUBMAIN);
        }

    }
}
