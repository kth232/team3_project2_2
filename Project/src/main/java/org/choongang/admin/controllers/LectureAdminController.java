package org.choongang.admin.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.lecture.Le_AdminControllerLocator;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.template.Templates;

public class LectureAdminController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(LectureMenu.LECTUREMAIN);
        //기본 출력 화면=반 선택 화면
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
                System.err.println("메뉴 1, 2 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo){
        ControllerLocator locator = Le_AdminControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo){
            case 1: controller = locator.find(LectureMenu.SELECTCLASS); break; //반 선택
            case 2: controller = locator.find(LectureMenu.BACK); break; //뒤로 가기->admin main화면
            default:
               controller = locator.find(LectureMenu.LECTUREMAIN);
        }

        if(controller != null){
            controller.run();
        }
    }
}
