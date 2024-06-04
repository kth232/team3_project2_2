package org.choongang.grades.constants;

import org.choongang.global.Menu;

public enum GradeMenu implements Menu {
    GRADEMAIN, //성적관리 메인 - 1.반선택 2.뒤로가기
    CLASSCHOICE, //반선택
    BACK, //뒤로 가기 (ADMINMENU)

    //성적관리 submain (반선택 이후)
    GRADESUBMAIN,
    GETGRADE, //성적조회
    MODGRADE, //성적수정
    LISTGRADE,

}
