package org.choongang.start.services;

import org.choongang.global.Service;
import org.choongang.start.controllers.InputJoin;
import org.choongang.start.controllers.InputLogin;

public class LoginService implements Service<InputLogin> {
    //사용자가 보낸(사용자에게 입력받은) 로그인 데이터 처리하는 클래스
    @Override
    public void process(InputLogin form) {

    } //로그인 기능
}
