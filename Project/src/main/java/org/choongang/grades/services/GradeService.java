package org.choongang.grades.services;

import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.grades.controllers.SearchGrade;
import org.choongang.grades.entities.Grade;
import org.choongang.grades.mapper.GradeMapper;

import java.util.Arrays;
import java.util.List;


public class GradeService implements Service<Grade>, Retrivable<SearchGrade, List<String>> {
    private final GradeMapper mapper;

    public GradeService(GradeMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void process(Grade form) {

    }

    @Override
    public List<String> get(SearchGrade search) {
        return Arrays.asList(
            "1반", "2반", "3반"
        );
    }
}
