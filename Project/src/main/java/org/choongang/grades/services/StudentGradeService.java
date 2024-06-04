package org.choongang.grades.services;

import org.choongang.global.Deletable;
import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.global.Updatable;
import org.choongang.grades.controllers.SearchGrade;
import org.choongang.grades.entities.StudentGrade;
import org.choongang.grades.mapper.StudentGradeMapper;

import java.util.List;

public class StudentGradeService implements Service<StudentGrade>, Retrivable<SearchGrade,StudentGrade>, Updatable<StudentGrade>, Deletable<StudentGrade> {

    private StudentGradeMapper mapper;

    public StudentGradeService(StudentGradeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<StudentGrade> getList() {
        List<String> classRooms = mapper.getClassList();
       return classRooms == null ? null : classRooms.stream().map(s -> StudentGrade.builder().studentClass(s).build())
                .toList();
    }

    @Override
    public List<StudentGrade> getList(SearchGrade search) {
        return mapper.getList(search);
    }

    @Override
    public int delete(StudentGrade form) {
        return mapper.delete(form);
    }

    @Override
    public int modify(StudentGrade form) {
        return mapper.modify(form);
    }
}
