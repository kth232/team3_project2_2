package org.choongang.start.services;

import org.choongang.global.*;
import org.choongang.global.configs.DBConn;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.member.mapper.MemberMapper;
import org.choongang.start.validators.JoinValidator;
import org.choongang.start.validators.LoginValidator;

public class StartServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new StartServiceLocator();
        }
        return instance;
    }

    // 회원가입 유효성 검사 Validator
    public JoinValidator joinValidator(){
        return new JoinValidator(memberMapper());
    }

    // 로그인 유효성 검사 Validator
    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

    // MemberMapper 인터페이스 구현체
    public MemberMapper memberMapper() {
        return DBConn.getSession().getMapper(MemberMapper.class);
    }
    @Override
    public Service find(Menu menu) {
        //서비스를 찾아주는 ServiceLocator 인터페이스 find 메서드 재정의

        //AbstractServiceLocator에 Map형태 정의되어있음
        Service service = services.get(menu); //조회

        if(service != null){
            return service;
        } //이미 생성된 객체 있으면 생성되어있는 객체를 반환값으로 넘김

        //없으면 추가
        if (menu instanceof StartMenu) {
            StartMenu startMenu = (StartMenu) menu;
            switch (startMenu){
                case JOIN: service = new JoinService(memberMapper(),joinValidator());
                    break;
                case LOGIN: service = new LoginService(memberMapper(), loginValidator());
                    break;
            }

        }
        services.put(menu,service);
        return service;
    }

}
