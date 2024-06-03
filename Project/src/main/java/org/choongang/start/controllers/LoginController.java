package org.choongang.start.controllers;

import org.choongang.admin.adminmain.AdminMainRouter;
import org.choongang.admin.constants.AdminMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Service;
import org.choongang.start.StartControllerLocator;
import org.choongang.start.UserSession;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.services.StartServiceLocator;
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
    }

    @Override
    public void prompt() {
         /*입력 검증
        입력받은 문자열이 predicate의 조건을 만족하는지 확인
        * predicate 인터페이스는 단일 추상 메서드 test(T t)를 포함
        * 주이진 인수를 테스트 하고 만족여부를 boolean 값으로 반환
        * 검증에 실패했을 경우 while문 계속 반복
        * */
        String userId = promptWithValidation("아이디: ", s-> !s.isBlank()); //값이 있을 경우에만 넘어가고 없을 경우 입력 반복
        String userPw = promptWithValidation("비밀번호: ", s-> !s.isBlank());

        InputLogin form = InputLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build(); //컨트롤러쪽에 사용자가 입력한 데이터 유입

        try{
            //로그인 처리
            // 기능 부분 LoginService와 연동
            Service service = StartServiceLocator.getInstance().find(StartMenu.LOGIN);
            //LoginService에서 사용자 로그인 처리기능 담당
            service.process(form);

            System.out.println("\n"+UserSession.getInstance().getUserName() +" "+ UserSession.getInstance().getUserJob()+"님, 로그인하셨습니다.\n");

            //로그인 성공시 Admin메인 페이지로 이동(1~4번 고르는 화면)
            ControllerLocator locator = StartControllerLocator.getInstance();
            Controller controller = locator.find(AdminMenu.ADMINMAIN);
           // AdminMainRouter.getInstance().change(AdminMenu.ADMINMAIN);

            if (controller != null) {
                controller.run();
            }

        }catch (RuntimeException e){
            //로그인 실패시 다시 로그인 페이지로 유입
            System.err.println(e.getMessage());
            StartMainRouter.getInstance().change(StartMenu.LOGIN);
        }
    }
}
