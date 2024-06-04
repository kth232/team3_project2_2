package org.choongang.grades.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.grades.entities.StudentGrade;
import org.choongang.grades.mapper.StudentGradeMapper;

import java.util.List;

public class StudentGradeService implements Service<StudentGrade>, Retrivable<Object,String>  {

    private StudentGradeMapper mapper;

    public StudentGradeService(StudentGradeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<String> getList() {
        return mapper.getClassList();
    }
}
