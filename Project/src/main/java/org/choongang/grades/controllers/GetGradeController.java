package org.choongang.grades.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.entities.Grade;
import org.choongang.grades.services.GradeServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class GetGradeController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(GradeMenu.GETGRADE);
    }

    @Override
    public void prompt() {
        try{
            Retrivable<SearchGrade, Grade> service = (Retrivable<SearchGrade, Grade>) GradeServiceLocator.getInstance().find(GradeMenu.LISTGRADE);
            System.out.println("유입3 getgradeC");
            System.out.println(service);
            String keyword = promptWithValidation("검색어 입력:", s -> !s.isBlank());

            //키워드로 찾기
            SearchGrade search = SearchGrade.builder()
                    .keyword(keyword)
                    .build();

            List<Grade> items = service.getList(search);
            String str = items.stream().map(l -> String.format("학생이름: %d, 클래스명: %s, 과목: %s, 점수: %s"))
                    .collect(Collectors.joining("\n"));
            Templates.getInstance().render(GradeMenu.LISTGRADE, () -> str);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
