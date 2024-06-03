package org.choongang.studentManagement.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentManagement {
        private long studentNo;
        private String studentName;
        private String studentClass;
        private String studentSubject;
        private String studentAddress;
        private String studentPhone;
}


