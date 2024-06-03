package org.choongang.lecture.services;

import org.choongang.global.*;
import org.choongang.global.configs.DBConn;
import org.choongang.lecture.constants.LectureMenu;
import org.choongang.lecture.mapper.LectureMapper;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.services.JoinService;
import org.choongang.start.services.LoginService;

public class LectureServiceLocator extends AbstractServiceLocator {

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
        switch (lectureMenu){
            case ADDLECTURE: service = new AddLectureService();
                break;
            case MODLECTURE: service = new ModLectureService();
                break;
        }
        return service;
    }

}
