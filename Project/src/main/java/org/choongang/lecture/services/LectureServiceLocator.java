package org.choongang.lecture.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.mapper.LectureMapper;

public class LectureServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new LectureServiceLocator();
        }
        return instance;
    }

    public LectureMapper selectMapper() {
        return DBConn.getSession().getMapper(LectureMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        //서비스를 찾아주는 ServiceLocator 인터페이스 find 메서드 재정의
        Service service = services.get(menu); //조회

        if(service != null){
            return service;
        } //있으면 있는거 사용

        //없으면 추가
        LectureMenu lectureMenu = (LectureMenu) menu;
        //System.out.println("메뉴0?");
        System.out.println(menu);
        switch (lectureMenu){
            case ADDLECTURE: service = new AddLectureService();
                break;
            case MODLECTURE: service = new ModLectureService();
                break;
            case LISTLECTURE: service = new LectureInfoService(selectMapper());
        }
        //System.out.println("메뉴?");
        System.out.println(lectureMenu);
        return service;
    }
}
