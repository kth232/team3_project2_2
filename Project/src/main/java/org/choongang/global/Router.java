package org.choongang.global;

/**
 * 사용자가 입력한 메뉴 번호, 문구 -> 해당하는 컨트롤러로 연결
 */
public interface Router {
    void change();
    void start();
}