package org.choongang.admin.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.studentManagement.SubStudentManagementControllerLocator;
import org.choongang.studentManagement.constants.StSMMenu;

public class StudentAdminController extends AbstractController {
    @Override
    public void show() {
        System.out.println("조회할 학생의 반을 선택하세요");
        System.out.println("1번 : 502호");
        System.out.println("2번 : 503호");
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("반 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 2) {
                    change(m);
                    break;
                }
            } catch (Exception e) {
                System.err.println("메뉴 1, 2 중에서 선택하세요");
            }
        }
    }
    private void change(int menuNo) {
        ControllerLocator locator = SubStudentManagementControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(StSMMenu.LISTSTUDENT502); break; // 502호 학생 정보 조회하기
            case 2: controller = locator.find(StSMMenu.LISTSTUDENT503); break; // 503호 학생 정보 조회하기
            case 3: controller = locator.find(StSMMenu.BACK); break; //뒤로 가기
            default:
                controller = locator.find(StSMMenu.STUDENTMAIN);
        }

        if (controller != null) {
            controller.run();
        }
    }
}
