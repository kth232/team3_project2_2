package org.choongang.studentManagement.controllers;


import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.entities.StudentManagement;
import org.choongang.studentManagement.services.StudentServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class AddStudentController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(StSMMenu.ADDSTUDENT);
    }

    //prompt 기본 동작 => 메뉴선택, 학급 추가용으로 재정의
    @Override
    public void prompt() {
        try {
            Retrivable<SearchStudent, StudentManagement> service = (Retrivable<SearchStudent, StudentManagement>) StudentServiceLocator.getInstance().find(StSMMenu.LISTSTUDENT502);
            String keyword = promptWithValidation("학생의 이름을 입력하세요:", s -> !s.isBlank());
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

        String StudentName = promptWithValidation("학생 이름: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentClass = promptWithValidation("반 정보: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentSubject = promptWithValidation("수강 과목: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentAddress = promptWithValidation("주소: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentPhone = promptWithValidation("전화번호: ",s -> !s.isBlank()); //공백일 경우 반복

        SearchStudent form = SearchStudent.builder() // DTO
                .StudentName(StudentName)
                .StudentClass(StudentClass)
                .StudentSubject(StudentSubject)
                .StudentAddress(StudentAddress)
                .StudentPhone(StudentPhone)
                .build(); //컨트롤러쪽에 사용자가 입력한 데이터 유입

        Router router = AdminMainRouter.getInstance();

        try {
            Service service = StudentServiceLocator.getInstance().find(StSMMenu.ADDSTUDENT);
            service.process(form); //주입

            // 추가 성공 시 추가한 데이터 출력 후 관리 페이지로 이동
            router.change(AdminMenu.STUDENT);
        } catch (RuntimeException e) {
            // 추가 실패 시 서브메인 페이지로 이동
            System.err.println(e.getMessage());
            router.change(AdminMenu.STUDENT);
        }
    }
}
