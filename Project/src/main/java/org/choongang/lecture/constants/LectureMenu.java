package org.choongang.lecture.constants;

import org.choongang.global.Menu;

public enum LectureMenu implements Menu {
    LECTUREMAIN, //학급관리 메인화면=반 선택 화면
    SELECTCLASS, //반 선택
    BACK, //뒤로 가기(ADMINMENU)
    
    //submain
    LECTURESUBMAIN, //학급관리 서브메인화면=학급 추가, 수정 선택 화면
    ADDLECTURE, //학급 추가하기
    MODLECTURE, //학급 수정하기
    LISTLECTURE // 학급 목록
}
