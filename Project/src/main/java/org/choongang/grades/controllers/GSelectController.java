package org.choongang.grades.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Deletable;
import org.choongang.global.Retrivable;
import org.choongang.global.Updatable;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.entities.StudentGrade;
import org.choongang.grades.services.GradeServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

//반 선택
public class GSelectController extends AbstractController {
    @Override
    public void show() {
        try {
            Retrivable<SearchGrade, StudentGrade> service = (Retrivable<SearchGrade, StudentGrade>) GradeServiceLocator.getInstance().find(GradeMenu.CLASSCHOICE);
            List<StudentGrade> items = service.getList();
            String str = items.stream().map(g -> String.format("반이름 : %s%n", g.getStudentClass())).collect(Collectors.joining("\n"));
            Templates.getInstance().render(GradeMenu.CLASSCHOICE, () -> str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void prompt() {
        try{
            Retrivable<SearchGrade, StudentGrade> service = (Retrivable<SearchGrade,StudentGrade>) GradeServiceLocator.getInstance().find(GradeMenu.LISTGRADE);
        while(true) {
            System.out.println("성적조회를 원하시는 반 이름을 입력하세요.");
            String keyword = promptWithValidation("반 입력 : ", s -> !s.isBlank());

            SearchGrade search = SearchGrade.builder().keyword(keyword).build();
            List<StudentGrade> items = service.getList(search);

            System.out.println(Templates.getInstance().doubleLine());
            System.out.println("순번      클래스명        학생명     과목명     점수");
            System.out.println(Templates.getInstance().doubleLine());

            for (int i = 0; i < items.size(); i++) {
                StudentGrade item = items.get(i);
                System.out.printf("%d       %7s      %5s     %5s   %7s%n", i, item.getStudentClass(), item.getStudentName(), item.getStudentSubject(), item.getStudentScore());
            }

            String menuNo = promptWithValidation("수정(1), 삭제(2): ", s -> !s.isBlank());
            try {
                int no = Integer.parseInt(menuNo);

                if (no < 1 || no > 2) {
                    System.err.println("메뉴1, 2번 중에서 선택하세요.");
                    continue;
                }

                String _index = promptWithValidation("순번 선택: ", s -> !s.isBlank());
                int index = Integer.parseInt(_index);
                StudentGrade form = items.get(index);

                if (no == 2) { // 삭제 처리
                    Deletable<StudentGrade> dService = (Deletable<StudentGrade>) GradeServiceLocator.getInstance().find(GradeMenu.LISTGRADE);
                    dService.delete(form);
                } else { // 수정
                    String _score = promptWithValidation("변경 점수: ", s -> !s.isBlank());

                    form.setStudentScore(_score);
                    Updatable<StudentGrade> uService = (Updatable<StudentGrade>) GradeServiceLocator.getInstance().find(GradeMenu.LISTGRADE);
                    uService.modify(form);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("숫자를 입력하세요.");
            }


            //List<SearchGrade> items = service.getList();

//            try{
//            List<String> items = service.getList(search);
//
//            String str = items.stream().map(g -> String.format("반이름1 : %s%n", g)).collect(Collectors.joining("\n"));
//            Templates.getInstance().render(GradeMenu.CLASSCHOICE, () -> str);
//            }catch(NullPointerException e){ e.getMessage(); }

           // String studentClass = promptWithValidation("성적출력 : ", s -> !s.isBlank());

            try{
                //int no = Integer.parseInt(studentClass);
                //Templates.getInstance().render(GradeMenu.GRADESUBMAIN);
                break;
            } catch(Exception e){
                System.out.println("1,2번 메뉴 중에 선택하세요.");}
            }


//            String classNo = sc.nextLine();
//            try{
//                int cn = Integer.parseInt(classNo);
//                if( cn >= 1 && cn <= 2){
//                    change(cn);
//                    break;
//                }
//            }catch (Exception e){
//                System.err.println("반 목록에 없는 반입니다. 다시 입력하세요.");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private void change(int menuNo){
//        ControllerLocator locator = GradeMainControllerLocator.getInstance();
//        Controller controller = null;
//        switch (menuNo){
//            case 1: controller = locator.find(GradeMenu.GETGRADE); break;
//            case 2: controller = locator.find(GradeMenu.MODGRADE); break;
//            default:
//                AdminMainRouter.getInstance().change(GradeMenu.GRADESUBMAIN);
//                return;
//        }
//
//        if (controller != null) {
//            controller.run();
//        }

}
