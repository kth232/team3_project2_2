//package org.choongang.studentManagement;
//
//import org.choongang.studentManagement.constants.StSMMenu;
//import org.choongang.admin.adminmain.controllers.AdminMainController;
//import org.choongang.admin.controllers.AttendanceAdminController;
//import org.choongang.admin.controllers.GradeAdminController;
//import org.choongang.admin.controllers.StudentAdminController;
//import org.choongang.global.AbstractControllerLocator;
//import org.choongang.global.Controller;
//import org.choongang.global.ControllerLocator;
//import org.choongang.global.Menu;
//import org.choongang.start.startmain.controllers.StartMainController;
//
//public class StSMControllerLocator extends AbstractControllerLocator {
//    private static ControllerLocator instance;
//
//    private StSMControllerLocator(){}
//
//    public static ControllerLocator getInstance() {
//        if(instance == null) {
//            instance = new StSMControllerLocator();
//        }
//        return instance;
//    }
//
//    @Override
//    public Controller find(Menu menu) {
//        Controller controller = controllers.get(menu);
//        if(controller != null) {
//            return controller;
//        }
//
//        if(menu instanceof StSMMenu){
//            StSMMenu StSMMenu = (StSMMenu) menu;
//            switch(StSMMenu) {
//                case STSELECT: controller = new GradeAdminController(); break;
//                case STUPDATE: controller = new AttendanceAdminController(); break;
//                case STBACK: controller = new StudentAdminController(); break;
//                default: controller = new AdminMainController(); break;
//
//            }
//        }else {
//            controller = new StartMainController();
//
//        }
//
//        controller.setMenu(menu);
//        controllers.put(menu,controller);
//        return controller;
//    }
//}
