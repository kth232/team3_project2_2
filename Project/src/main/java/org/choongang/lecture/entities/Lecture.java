package org.choongang.lecture.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Lecture {//데이터 베이스에서 조회한 레코드 담는 클래스 (학급 정보 관련)
    private long classNo;
    private String subject; //과목명
    private String classNm; //반 이름
    private LocalDateTime openingDate; //개설일
    private LocalDateTime completionDate; //수료일
    private String classState; //학급 상태
}
