package org.choongang.start.services;

import org.choongang.global.*;
import org.choongang.start.constants.StartMenu;

public class StartServiceLocator extends AbstractServiceLocator {

    protected static ServiceLocator instance;

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new StartServiceLocator();
        }
        return instance;
    }
    @Override
    public Service find(Menu menu) {
        //서비스를 찾아주는 ServiceLocator 인터페이스 find 메서드 재정의
        Service service = services.get(menu); //조회

        if(service != null){
            return service;
        } //있으면 있는거 사용

        //없으면 추가
        if (menu instanceof StartMenu) {
            StartMenu startMenu = (StartMenu) menu;
            switch (startMenu) {
                case JOIN:
                    service = new JoinService();
                    break;
                case LOGIN:
                    service = new LoginService();
                    break;
            }
        }
        return service;
    }

}
