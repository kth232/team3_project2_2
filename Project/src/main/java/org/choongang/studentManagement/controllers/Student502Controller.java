package org.choongang.studentManagement.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.studentManagement.SubStudentManagementControllerLocator;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.template.Templates;

public class Student502Controller extends AbstractController {
    @Override
    public void show() {
        //기본 출력 화면=서브메인
        Templates.getInstance().render(StSMMenu.LISTSTUDENT502);
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("학생 추가와 수정 중 선택해주세요");
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
    private void change(int menuNo) {
        ControllerLocator locator = SubStudentManagementControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(StSMMenu.ADDSTUDENT); break; // 학생 정보 추가하기
            case 2: controller = locator.find(StSMMenu.MODSTUDENT); break; // 학생 정보 수정하기
            default:
                AdminMainRouter.getInstance().change(StSMMenu.LISTSTUDENT502);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
