package org.choongang.start.services;

import org.choongang.global.Service;
import org.choongang.start.controllers.InputJoin;
import org.choongang.start.controllers.InputLogin;

public class LoginService implements Service<InputLogin> {
    //사용자가 보낸(사용자에게 입력받은) 로그인 데이터 처리하는 클래스
    @Override
    public void process(InputLogin form) {
        //로그인 유효성 검사 - 예외 발생하지 않으면 이상 없음

        //회원정보 조회

        //로그인 처리

    } //로그인 기능
}
