package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class InputModLec { //사용자가 입력한 학급 정보 전달용 클래스
    private String Subject; //과목명
    private String ClassNm; //반 이름
    private LocalDateTime OpeningDt; //개설일
    private LocalDateTime CompletionDt; //수료일
    private String ClassState; //학급 상태
}
