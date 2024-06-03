package org.choongang.grades.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchGrade {
    private String Name;
    private String classNm;
    private String Subject;
    private int Score; //점수
    private String Grade; //등급
}
