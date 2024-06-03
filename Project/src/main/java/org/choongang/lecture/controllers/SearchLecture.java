package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchLecture {
    private String Subject; //과목명
    private String ClassNm; //반 이름
    private String OpeningDt; //개설일
    private int CompletionDt; //수료일
    private String ClassState; //학급 상태
}
