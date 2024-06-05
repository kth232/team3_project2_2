package org.choongang.grades.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchGrade {
    private String studentName;
    private String studentClass;
    //private String student_class;
    //private String classNm;
    //private String Subject;
    //private int Score; //점수
    private int studentScore;
    private String studentSubject;
    private String keyword;
}
