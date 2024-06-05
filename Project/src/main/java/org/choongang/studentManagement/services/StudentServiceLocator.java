package org.choongang.studentManagement.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.mapper.StudentManagementMapper;

public class StudentServiceLocator extends AbstractServiceLocator {
    private static ServiceLocator instance;

    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new StudentServiceLocator();
        }
        return instance;
    }

    public StudentManagementMapper selectMapper() {
        return DBConn.getSession().getMapper(StudentManagementMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu); //조회

        if(service != null){
            return service;
        } //있으면 있는거 사용

        //없으면 추가
        StSMMenu stsmMenu = (StSMMenu) menu;
        System.out.println(menu);
        switch (stsmMenu){
            case ADDSTUDENT: service = new AddStudentService();
                break;
            case MODSTUDENT: service = new ModStudentService();
                break;
            case LISTSTUDENT502: service = new Student502InfoService(selectMapper());
                break;
            case LISTSTUDENT503: service = new Student503InfoService(selectMapper());
                break;
        }
        System.out.println(stsmMenu);
        return service;
    }
}
