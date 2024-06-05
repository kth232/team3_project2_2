package org.choongang.studentManagement.mapper;

import org.choongang.studentManagement.entities.StudentManagement;

import java.util.List;

public interface StudentManagementMapper {
    List<StudentManagement> get502StudentList();
    List<StudentManagement> get503StudentList();
    int studentRegister(StudentManagement studentManagement);
    int studentModify(StudentManagement studentManagement);
}
