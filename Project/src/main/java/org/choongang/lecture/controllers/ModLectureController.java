package org.choongang.lecture.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.services.LectureServiceLocator;
import org.choongang.template.Templates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModLectureController extends AbstractController {
    @Override
    public void show() {
        //기본 출력 화면=서브메인
        Templates.getInstance().render(LectureMenu.MODLECTURE);
    }

    //prompt 기본 동작 => 메뉴선택, 학급 추가용으로 재정의
    @Override
    public void prompt() {
        /*입력 검증
        입력받은 문자열이 predicate의 조건을 만족하는지 확인
        * predicate 인터페이스는 단일 추상 메서드 test(T t)를 포함
        * 주이진 인수를 테스트 하고 만족여부를 boolean 값으로 반환
        * 검증에 실패했을 경우 while문 계속 반복
        * */
        String Subject = promptWithValidation("과목명: ",s -> !s.isBlank()); //공백일경우 반복

        String ClassNm = promptWithValidation("반 명: ",s -> !s.isBlank()); //공백일경우 반복

        String OpeningDt = promptWithValidation("개설일: ",s -> !s.isBlank()); //공백일 경우 반복

        String CompletionDt = promptWithValidation("수료일: ",s -> !s.isBlank()); //공백일 경우 반복

        String ClassState = promptWithValidation("학급 상태: ",s -> !s.isBlank()); //공백일 경우 반복

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        SearchLecture form = SearchLecture.builder() // DTO
                .Subject(Subject)
                .ClassNm(ClassNm)
                .OpeningDt(LocalDateTime.parse(OpeningDt, formatter))
                .CompletionDt(LocalDateTime.parse(CompletionDt, formatter))
                .ClassState(ClassState)
                .build(); //컨트롤러쪽에 사용자가 입력한 데이터 유입

        Router router = AdminMainRouter.getInstance();
        try {
            //학급 수정 처리
            //기능 부분은 ModLectureService와 연동
            Service service = LectureServiceLocator.getInstance().find(LectureMenu.MODLECTURE);
            //AddLectureService에서 학급 추가 처리 담당
            service.process(form); //주입

            //학급 추가 성공 시 추가한 데이터 출력 후 학급관리 페이지로 이동
            router.change(LectureMenu.LECTUREMAIN);
        } catch (RuntimeException e) {
            //학급 추가 실패 시 학급관리 서브메인 페이지로 이동
            System.err.println(e.getMessage());
            router.change(LectureMenu.LECTURESUBMAIN);
        }
    }
}
