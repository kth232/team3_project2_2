package org.choongang.start.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.start.UserSession;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.services.StartServiceLocator;
import org.choongang.start.startmain.StartMainRouter;
import org.choongang.template.Templates;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.function.Predicate;

/**
 * 회원가입 컨트롤러
 */
public class JoinController extends AbstractController {
    @Override
    public void show() {
        //System.out.println("JoinTpl화면");
        Templates.getInstance().render(StartMenu.JOIN);
    }

    //prompt 기본 동작 => 메뉴선택, 회원가입용으로 재정의
    @Override
    public void prompt() {
        /*입력 검증
        입력받은 문자열이 predicate의 조건을 만족하는지 확인
        * predicate 인터페이스는 단일 추상 메서드 test(T t)를 포함
        * 주이진 인수를 테스트 하고 만족여부를 boolean 값으로 반환
        * 검증에 실패했을 경우 while문 계속 반복
        * */

        String userName = promptWithValidation("이름을 입력해주세요: ",s -> !s.isBlank()); //공백일경우 반복

        String userId = promptWithValidation("가입 아이디를 입력해주세요(6자리 이상): ", s -> s.length() >= 6); //판별식 6자리 이상일경우 true반환
        System.out.println(userId);

        String userPw = promptWithValidation("비밀번호를 입력해주세요(8자리 이상): ", s -> s.length() >= 8); //판별식 8자리 이상일경우 true반환

        String confirmPw = promptWithValidation("비밀번호 확인: ", s -> {
            boolean match = s.equals(userPw); //비밀번호 일치 여부 확인
            if(!match){
                System.err.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            }
            return match; //비밀번호 일치하지 않을 경우 false
            //fasle일 경우 판별식 반복
        });
        String userJob =promptWithValidation("직책을 입력해주세요(강사/매니저): ", s -> {
            boolean match = true;
            if(!s.equals("강사") && !s.equals("매니저")){
                System.err.println("직책은 강사 또는 매니저 중 입력해주세요.");
                match = false;
            }
            return match;
        });

        InputJoin form = InputJoin.builder() //값 하나씩 넣어서 전달?
                .userName(userName)
                .userId(userId)
                .userPw(userPw)
                .confirmPw(confirmPw)
                .userJob(userJob)
                .build(); //컨트롤러쪽에 사용자가 입력한 데이터 유입


        Router router = StartMainRouter.getInstance();
        try{
            //회원가입 처리
            // 기능 부분 JoinService와 연동
            Service service = StartServiceLocator.getInstance().find(StartMenu.JOIN);
            //JoinService에서 사용자 회원가입 처리기능 담당
            service.process(form); //주입

            UserSession.getInstance().setUserName(userName);
            UserSession.getInstance().setUserJob(userJob);

            //회원가입 성공시 로그인 페이지로 이동
            router.change(StartMenu.LOGIN);

        }catch (RuntimeException e){
            //회원가입 실패시 다시 회원가입 페이지로 유입
            System.err.println(e.getMessage());
            router.change(StartMenu.JOIN);
        }


    }


}
