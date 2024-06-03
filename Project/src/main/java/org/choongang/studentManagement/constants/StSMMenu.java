package org.choongang.studentManagement.constants;

import org.choongang.global.Menu;

public enum StSMMenu implements Menu {
    STUDENTMAIN, // 학급관리 메인화면 = 반을 선택하는 화면
    STUDENTCLASS, // 반 선택
    BACK, // 뒤로 가기 (ADMINMENU)

    // submain
    STUDENTSUBMAIN, // 학생관리 서브메인화면
    ADDSTUDENT, // 학생 정보 추가하기
    MODSTUDENT, // 학생 정보 수정하기
    LISTSTUDENT502, // 502 학생 정보 조회
    LISTSTUDENT503, // 503 학생 정보 조회
}
