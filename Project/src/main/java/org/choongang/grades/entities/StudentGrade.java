package org.choongang.grades.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentGrade {
    private String studentName;
    private String studentClass;
    private String studentSubject;
    private String studentScore;
}
