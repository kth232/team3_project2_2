package org.choongang.lecture.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.lecture.controllers.SearchLecture;
import org.choongang.lecture.entities.Lecture;
import org.choongang.lecture.mapper.LectureMapper;

import java.util.Arrays;
import java.util.List;

public class AddLectureService implements Service<Lecture> ,     Retrivable<SearchLecture, List<String>> {
    //사용자가 보낸(사용자에게 입력받은) 회원가입 데이터 처리하는 클래스
    private final LectureMapper mapper() {
        return null;
    };


    @Override
    public void process(Lecture form) {

        //회원가입 유효성 검사

        //비밀번호 해시화

        //데이터베이스에 영구저장

    } //학급 추가 기능
    
    @Override
    public List<String> get(SearchLecture search) {
        return Arrays.asList(
                "1반", "2반", "3반"
        );
    }
}
