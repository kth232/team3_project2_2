package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class InputAddLec { //사용자가 입력한 학급 정보 전달용 클래스
    private String subject;
    private String classNm;
    private LocalDate openingDate;
    private LocalDate completionDate;
    private String classState;
}
