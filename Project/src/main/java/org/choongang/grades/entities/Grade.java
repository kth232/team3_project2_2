package org.choongang.grades.entities;

import lombok.Data;

@Data
public class Grade {
    private String grade;
    private int low_score;
    private int high_score;
}
