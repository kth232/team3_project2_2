package org.choongang.global;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator{

    protected Map<Menu, Service> services;
    //싱글톤을 사용하기 위함/ 이미 있는 메뉴, 서비스를 재사용함

    protected AbstractServiceLocator() {
        services = new HashMap<>();
    }
}
