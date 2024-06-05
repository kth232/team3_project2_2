package org.choongang.studentManagement.controllers;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchStudent {
        private String StudentName; // 학생 이름
        private String StudentClass; // 반 정보
        private String StudentSubject; // 수강 과목
        private String StudentAddress; // 주소
        private String StudentPhone; // 전화번호
        private String keyword;

}
