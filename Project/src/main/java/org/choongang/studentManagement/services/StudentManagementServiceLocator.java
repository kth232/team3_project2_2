package org.choongang.studentManagement.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.configs.DBConn;
import org.choongang.studentManagement.mapper.StudentManagementMapper;

public class StudentManagementServiceLocator extends AbstractServiceLocator {

    public StudentManagementMapper studentManagementMapper() {
        return DBConn.getSession().getMapper(StudentManagementMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        return null;
    }
}
