package org.choongang.admin.controllers;

import org.choongang.admin.AdminControllerLocator;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.constants.StartMenu;
import org.choongang.template.Templates;

public class AttendanceAdminController extends AbstractController {
    @Override
    public void show() {

        Templates.getInstance().render(AdminMenu.ATTENDANCE);

        ControllerLocator locator = AdminControllerLocator.getInstance();
        Controller controller = locator.find(AdminMenu.ATTENDANCE);

       // if (controller != null) {
        //    controller.run();
        }
    }

