package org.choongang.admin.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.studentManagement.StudentManagementControllerLocator;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.template.Templates;

public class StudentAdminController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(AdminMenu.STUDENT);
    }

    @Override
    public void prompt() {
        while(true) {
            System.out.print("반을 선택하세요 : ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 3) {
                    change(m);
                    break;
                }
            } catch (Exception e) {
                System.err.println("메뉴 1, 2, 3중에서 선택하세요");
            }
        }
    }
    private void change(int menuNo) {
        ControllerLocator locator = StudentManagementControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(StSMMenu.LISTSTUDENT502); break; // 502호 학생 정보 조회하기
            case 2: controller = locator.find(StSMMenu.LISTSTUDENT503); break; // 503호 학생 정보 조회하기
            case 3: controller = locator.find(StSMMenu.BACK); break; // 뒤로 돌아가기
            default:
                AdminMainRouter.getInstance().change(AdminMenu.STUDENT);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
