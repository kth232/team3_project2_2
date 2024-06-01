package org.choongang.global;

public interface Controller extends Runnable{
    void show(); // 서비스(Model)와 뷰를 연결

    default void setMenu(Menu menu){

    }
}