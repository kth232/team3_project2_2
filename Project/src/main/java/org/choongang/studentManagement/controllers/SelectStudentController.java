package org.choongang.studentManagement.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.entities.StudentManagement;
import org.choongang.studentManagement.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class SelectStudentController extends AbstractController {
    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        try {
            Retrivable<SearchStudent, StudentManagement> service = (Retrivable<SearchStudent, StudentManagement>) StudentServiceLocator.getInstance().find(StSMMenu.LISTSTUDENT);
            System.out.println(service);
            String keyword = promptWithValidation("검색어 입력:", s -> !s.isBlank());

            SearchStudent search = SearchStudent.builder()
                    .keyword(keyword)
                    .build();

            List<StudentManagement> items = service.getList(search);
            String str = items.stream().map(s -> String.format("학생 이름: %d, 반 정보: %s, 수강 과목: %s, 주소: %s, 전화번호: %s%n", s.getStudentName(), s.getStudentClass(), s.getStudentSubject(), s.getStudentAddress(), s.getStudentPhone()))
                    .collect(Collectors.joining("\n"));
            Templates.getInstance().render(StSMMenu.STUDENTMAIN, () -> str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
