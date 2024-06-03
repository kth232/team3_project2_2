package org.choongang.lecture.entities;

import java.time.LocalDateTime;

public class Lecture {//데이터 베이스에서 조회한 레코드 담는 클래스 (학급 정보 관련)
    private String subject; //과목명
    private String classNm; //반 이름
    private LocalDateTime openingDt; //개설일
    private LocalDateTime completionDt; //수료일
    private String classState; //학급 상태
}
