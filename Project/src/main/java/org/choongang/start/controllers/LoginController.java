package org.choongang.start.controllers;

import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.template.Templates;


/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    @Override
    public void show() {
        //System.out.println("LoginTpl화면");
        Templates.getInstance().render(StartMenu.LOGIN);
        System.out.println("로그인 과정 생략 ...");
        System.out.println("로그인 완료 후 자동으로 AdminMain화면 출력되게 해야함 ...");

        ControllerLocator locator = StartControllerLocator.getInstance();
        Controller controller = locator.find(AdminMenu.ADMINMAIN);

        if (controller != null) {
            controller.run();
        }
    }

}
