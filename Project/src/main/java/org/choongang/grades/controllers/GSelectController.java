package org.choongang.grades.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Retrivable;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.services.GradeServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

//반 선택
public class GSelectController extends AbstractController {
    @Override
    public void show() {
        try {
            Retrivable<Object, String> service = (Retrivable<Object, String>) GradeServiceLocator.getInstance().find(GradeMenu.CLASSCHOICE);
            List<String> items = service.getList();
            String str = items.stream().map(g -> String.format("반이름 : %s%n", g)).collect(Collectors.joining("\n"));
            Templates.getInstance().render(GradeMenu.CLASSCHOICE, () -> str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void prompt() {
        try{
        while(true) {
            Retrivable<SearchGrade, String> service = (Retrivable<SearchGrade, String>) GradeServiceLocator.getInstance().find(GradeMenu.LISTGRADE);

            System.out.println("성적조회를 원하시는 반 이름을 입력하세요.");
            String keyword = promptWithValidation("반 입력:", s -> !s.isBlank());

            SearchGrade search = SearchGrade.builder().keyword(keyword).build();

            //List<SearchGrade> items = service.getList();
            List<String> items = service.getList(search);
            String str = items.stream().map(g -> String.format("반이름 : %s%n", g)).collect(Collectors.joining("\n"));
            Templates.getInstance().render(GradeMenu.CLASSCHOICE, () -> str);

            String studentClass = promptWithValidation("반이름 : ", s -> !s.isBlank());

            try{
                int no = Integer.parseInt(studentClass);
                Templates.getInstance().render(GradeMenu.GRADESUBMAIN);
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
