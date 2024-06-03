package org.choongang.lecture.services;

import org.choongang.global.Service;
import org.choongang.lecture.entities.Lecture;

public class ModLectureService implements Service<Lecture> {
    //사용자가 보낸(사용자에게 입력받은) 회원가입 데이터 처리하는 클래스

    @Override
    public void process(Lecture form) {

        //유효성 검사

        //비밀번호 해시화

        //데이터베이스에 영구저장

    } //학급 수정 기능
}
