package org.choongang.lecture.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LectureSearch { //검색 위한 키워드 변수 정의
    private String keyword;
}
