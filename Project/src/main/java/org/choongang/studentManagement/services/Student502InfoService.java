package org.choongang.studentManagement.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.studentManagement.controllers.SearchStudent;
import org.choongang.studentManagement.entities.StudentManagement;
import org.choongang.studentManagement.mapper.StudentManagementMapper;

import java.util.List;

public class Student502InfoService implements Service<StudentManagement>, Retrivable<SearchStudent, StudentManagement>{

    private final StudentManagementMapper mapper;

    public Student502InfoService(StudentManagementMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<StudentManagement> getList(SearchStudent search) {
        return mapper.get502StudentList();
    }
}
