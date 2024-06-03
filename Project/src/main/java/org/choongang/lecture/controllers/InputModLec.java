package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InputModLec { //사용자가 입력한 학급 정보 전달용 클래스
    private String subject; //과목명
    private String classNm; //반 이름
    private LocalDate openingDate; //개설일
    private LocalDate completionDate; //수료일
    private String classState; //학급 상태
}
