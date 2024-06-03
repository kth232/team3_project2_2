package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchLecture {
    //검색 위한 키워드 변수 정의
    private String keyword;

    private int ClassNo; //학급 번호
    private String Subject; //과목명
    private String ClassNm; //반 이름
    private int OpeningDt; //개설일
    private int CompletionDt; //수료일
    private String ClassState; //학급 상태
}
