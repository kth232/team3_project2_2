package org.choongang.grades.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.grades.controllers.SearchGrade;
import org.choongang.grades.entities.Grade;
import org.choongang.grades.mapper.GradeMapper;

import java.util.List;


public class GradeService implements Service<Grade>, Retrivable<SearchGrade,Grade> {
    private final GradeMapper mapper;

    public GradeService(GradeMapper mapper){
        this.mapper = mapper;
    }
    //매퍼
    @Override
    public void process(Grade form) {

    }

    @Override
    public List<Grade> getList() {
        return mapper.getList();
    }

}
