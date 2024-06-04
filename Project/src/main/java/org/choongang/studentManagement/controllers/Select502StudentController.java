package org.choongang.studentManagement.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.entities.StudentManagement;
import org.choongang.studentManagement.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class Select502StudentController extends AbstractController {
    @Override
    public void show() {
        System.out.println("502호를 선택하였습니다" );
        Templates.getInstance().render(StSMMenu.LISTSTUDENT502);
    }

    @Override
    public void prompt() {
        try {
            Retrivable<SearchStudent, StudentManagement> service = (Retrivable<SearchStudent, StudentManagement>) StudentServiceLocator.getInstance().find(StSMMenu.LISTSTUDENT502);
            String keyword = promptWithValidation("학생의 이름을 입력하세요:", s -> !s.isBlank());
            System.out.println(service);
            SearchStudent search = SearchStudent.builder()
                    .keyword(keyword)
                    .build();

            List<StudentManagement> items = service.getList(search);
            String str = items.stream().map(s -> String.format("학생 이름: %d, 반 정보: %s, 수강 과목: %s, 주소: %s, 전화번호: %s%n", s.getStudentName(), s.getStudentClass(), s.getStudentSubject(), s.getStudentAddress(), s.getStudentPhone()))
                    .collect(Collectors.joining("\n"));
            Templates.getInstance().render(StSMMenu.LISTSTUDENT502, () -> str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
