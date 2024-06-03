package org.choongang.lecture.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Retrivable;
import org.choongang.lecture.Sub_Le_AdminControllerLocator;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.entities.Lecture;
import org.choongang.lecture.services.LectureServiceLocator;
import org.choongang.template.Templates;
import org.choongang.template.lecture.SubLectureTpl;

import java.util.List;
import java.util.stream.Collectors;

public class LSelectController extends AbstractController {
    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        try {
            Retrivable<SearchLecture, Lecture> service = (Retrivable<SearchLecture, Lecture>) LectureServiceLocator.getInstance().find(LectureMenu.LISTLECTURE);
           // System.out.println("유입2");
           // System.out.println(service);
            String keyword = promptWithValidation("검색어 입력:", s -> !s.isBlank());

            SearchLecture search = SearchLecture.builder()
                    .keyword(keyword)
                    .build();

            List<Lecture> items = service.getList(search);
            String str = items.stream().map(l -> String.format("클래스 번호: %d, 클래스명: %s, 과목: %s%n", l.getClassNo(), l.getClassNm(), l.getSubject()))
                    .collect(Collectors.joining("\n"));
            Templates.getInstance().render(LectureMenu.LISTLECTURE, () -> str);

            Templates.getInstance().render(LectureMenu.LECTURESUBMAIN);

            while(true) {
                System.out.print("메뉴 선택: ");
                String menu = sc.nextLine();
                try {
                    int m = Integer.parseInt(menu);
                    if (m >= 1 && m <= 2) {
                        //change(m);
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("메뉴 1,2 중에서 선택하세요.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void change(int menuNo) {
        ControllerLocator locator = Sub_Le_AdminControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(LectureMenu.ADDLECTURE); break; //학급 추가하기
            case 2: controller = locator.find(LectureMenu.MODLECTURE); break; //학급 수정하기
            default:
                AdminMainRouter.getInstance().change(LectureMenu.LECTURESUBMAIN); //서브메인
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
