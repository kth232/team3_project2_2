package org.choongang.studentManagement.mapper;

import org.choongang.studentManagement.entities.StudentManagement;

import java.util.List;

public interface StudentManagementMapper {
    List<StudentManagement> get502StudentList(String studentClass);
    List<StudentManagement> get503StudentList(String studentClass);
    int studentRegister(StudentManagement studentManagement);
    int studentModify(StudentManagement studentManagement);
}
