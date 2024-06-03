package org.choongang.attendance.services;

import org.apache.ibatis.annotations.Mapper;
import org.choongang.attendance.constants.AttendanceMenu;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.mapper.GradeMapper;
import org.choongang.grades.services.GradeServiceLocator;

public class AttendanceServiceLocator extends AbstractServiceLocator {
    public static ServiceLocator getInstance(){
        if(instance == null){
            instance = new AttendanceServiceLocator();
        }

        return instance;
    }

    public AttendanceMapper selectMapper(){
        return DBConn.getSession().getMapper(AttendanceMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        Service service = services.get(menu);
        if(service != null){
            return service;
        }

        AttendanceMenu attendanceMenu = (AttendanceMenu) menu;
        switch (attendanceMenu){
            //case Class502 : service
            //case Class503 : service
        }

        return service;
    }
}



