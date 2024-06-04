package org.choongang.studentManagement.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.services.StudentServiceLocator;
import org.choongang.template.Templates;

public class ModStudentController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(StSMMenu.MODSTUDENT);
    }

    @Override
    public void prompt() {

        String StudentClass = promptWithValidation("반 정보: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentSubject = promptWithValidation("수강 과목: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentAddress = promptWithValidation("주소: ",s -> !s.isBlank()); //공백일 경우 반복

        String StudentPhone = promptWithValidation("전화번호: ",s -> !s.isBlank()); //공백일 경우 반복

        SearchStudent form = SearchStudent.builder() // DTO
                .StudentClass(StudentClass)
                .StudentSubject(StudentSubject)
                .StudentAddress(StudentAddress)
                .StudentPhone(StudentPhone)
                .build(); //컨트롤러쪽에 사용자가 입력한 데이터 유입

        Router router = AdminMainRouter.getInstance();

        try {
            Service service = StudentServiceLocator.getInstance().find(StSMMenu.MODSTUDENT);
            service.process(form); //주입

            //AddLectureService에서 학급 추가 처리 담당
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
