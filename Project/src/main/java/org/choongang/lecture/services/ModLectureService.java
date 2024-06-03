package org.choongang.lecture.services;

import org.choongang.global.Service;
import org.choongang.lecture.controllers.InputAddLec;

public class ModLectureService implements Service<InputAddLec> {
    //사용자가 보낸(사용자에게 입력받은) 회원가입 데이터 처리하는 클래스

    @Override
    public void process(InputAddLec form) {

        //회원가입 유효성 검사

        //비밀번호 해시화

        //데이터베이스에 영구저장

    } //회원가입 기능
}
