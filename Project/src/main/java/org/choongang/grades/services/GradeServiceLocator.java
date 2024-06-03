package org.choongang.grades.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.mapper.GradeMapper;

public class GradeServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new GradeServiceLocator();
        }

        return instance;
    }

    public GradeMapper selectMapper(){
        return DBConn.getSession().getMapper(GradeMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service != null){
            return service;
        }

        GradeMenu gradeMenu = (GradeMenu) menu;
        switch (gradeMenu){
            //case Class502 : service
            //case Class503 : service
        }

        return service;
    }
}
