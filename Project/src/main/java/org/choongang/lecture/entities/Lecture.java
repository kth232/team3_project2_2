package org.choongang.lecture.entities;

import java.time.LocalDate;

public class Lecture {//데이터 베이스에서 조회한 레코드 담는 클래스 (학급 정보 관련)
    private String Subject; //과목명
    private String ClassNm; //반 이름
    private LocalDate OpeningDt; //개설일
    private LocalDate CompletionDt; //수료일
    private String ClassState; //학급 상태
}
