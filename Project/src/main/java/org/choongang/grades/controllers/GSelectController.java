package org.choongang.grades.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Retrivable;
import org.choongang.grades.GradeMainControllerLocator;
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
        System.out.println("유입2");
        while(true) {
            System.out.println("원하는 성적관리 서비스를 선택하세요.");
            System.out.print("성적관리 서비스 메뉴 :");
            String classNo = sc.nextLine();
            try{
                int cn = Integer.parseInt(classNo);
                if( cn >= 1 && cn <= 2){
                    change(cn);
                    break;
                }
            }catch (Exception e){
                System.err.println("메뉴를 1, 2번 중에 선택하세요.");
            }

        }
    }

    private void change(int menuNo){
        ControllerLocator locator = GradeMainControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo){
            case 1: controller = locator.find(GradeMenu.GETGRADE); break;
            case 2: controller = locator.find(GradeMenu.MODGRADE); break;
            default:
                AdminMainRouter.getInstance().change(GradeMenu.GRADESUBMAIN);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
