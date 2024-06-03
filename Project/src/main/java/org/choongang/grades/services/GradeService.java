package org.choongang.grades.services;

import org.choongang.global.Service;
import org.choongang.grades.entities.Grade;
import org.choongang.grades.mapper.GradeMapper;

import java.util.List;


public class GradeService implements Service<Grade> {
    private final GradeMapper mapper;

    public GradeService(GradeMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public List<Grade> process() {
        //return mapper.
    }
}
