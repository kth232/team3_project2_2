package org.choongang.start.services;

import org.choongang.global.Service;
import org.choongang.start.MemberSession;
import org.choongang.start.controllers.InputJoin;
import org.choongang.start.controllers.InputLogin;
import org.choongang.start.member.entities.Member;
import org.choongang.start.member.mapper.MemberMapper;
import org.choongang.start.validators.LoginValidator;

public class LoginService implements Service<InputLogin> {
    //사용자가 보낸(사용자에게 입력받은) 로그인 데이터 처리하는 클래스

    private final LoginValidator validator;
    private final MemberMapper mapper;


    public LoginService(MemberMapper mapper, LoginValidator validator) {
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public void process(InputLogin form) {
        //로그인 유효성 검사 - 예외 발생하지 않으면 이상 없음
        validator.check(form);
        //회원정보 조회
        Member member = mapper.get(form.getUserId());
        //로그인 처리
        MemberSession.login(member);
    } //로그인 기능
}
