package org.choongang.lecture.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.lecture.Sub_Le_AdminControllerLocator;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.template.Templates;

public class SubLectureController extends AbstractController {
    @Override
    public void show() {
        //기본 출력 화면=서브메인
        Templates.getInstance().render(LectureMenu.LECTURESUBMAIN);
    }


    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 2) {
                    change(m);
                    break;
                }
            } catch (Exception e) {
                System.err.println("메뉴 1,2 중에서 선택하세요.");
            }
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
