package org.choongang.grades.mapper;

import org.apache.ibatis.annotations.Select;
import org.choongang.grades.controllers.SearchGrade;
import org.choongang.grades.entities.StudentGrade;

import java.util.List;

public interface StudentGradeMapper {
    List<StudentGrade> getList(SearchGrade search);

    @Select("SELECT DISTINCT STUDENT_CLASS FROM STUDENTGRADE")
    List<String> getClassList();
    int delete(StudentGrade form);
    int modify(StudentGrade form);
}
