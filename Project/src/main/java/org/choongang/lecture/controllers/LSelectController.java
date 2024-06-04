package org.choongang.lecture.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.entities.Lecture;
import org.choongang.lecture.services.LectureServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class LSelectController extends AbstractController {
    @Override
    public void show() {

    }

    @Override
    public void prompt() {
        try {
            while(true) {
                Retrivable<SearchLecture, Lecture> service = (Retrivable<SearchLecture, Lecture>) LectureServiceLocator.getInstance().find(LectureMenu.LISTLECTURE);
                //System.out.println("유입2");
                //System.out.println(service);
                System.out.println("원하는 학급명을 입력하세요.");
                System.out.println("502 / 503");
                String keyword = promptWithValidation("검색어 입력:", s -> !s.isBlank());

                SearchLecture search = SearchLecture.builder()
                        .keyword(keyword)
                        .build();

                List<Lecture> items = service.getList(search);
                String str = items.stream().map(l -> String.format("학급 번호: %d, 과목: %s, 학급명: %s, 학급 상태: %s%n", l.getClassNo(), l.getSubject(), l.getClassNm(), l.getClassState()))
                        .collect(Collectors.joining(""));
                Templates.getInstance().render(LectureMenu.LISTLECTURE, () -> str);


                String classNo = promptWithValidation("학급번호: ", s -> !s.isBlank());
                //String menuNo = promptWithValidation("수정(1), 삭제(2): ", s -> !s.isBlank());

                try {
                    int no = Integer.parseInt(classNo);
                    Templates.getInstance().render(LectureMenu.LECTURESUBMAIN);

                    break;
                } catch(Exception e) {
                    System.err.println("1, 2번 메뉴 중에서 선택하세요.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
