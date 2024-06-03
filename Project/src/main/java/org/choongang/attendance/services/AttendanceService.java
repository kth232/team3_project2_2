package org.choongang.attendance.services;

import org.apache.ibatis.annotations.Mapper;
import org.choongang.attendance.mapper.AttendanceMapper;
import org.choongang.global.Retrivable;
import org.choongang.global.Service;
import org.choongang.grades.controllers.SearchGrade;
import org.choongang.grades.entities.Grade;
import org.choongang.grades.mapper.GradeMapper;

import java.util.Arrays;
import java.util.List;

public class AttendanceService implements Service<Grade>, Retrivable<SearchGrade, List<String>> {
    private final AttendanceMapper mapper;

    public AttendanceService(AttendanceMapper mapper){
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


