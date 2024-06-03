package org.choongang.studentManagement.services;

import org.choongang.global.Service;
import org.choongang.studentManagement.entities.StudentManagement;
import org.choongang.studentManagement.mapper.StudentManagementMapper;

public class AddStudentService implements Service<StudentManagement> {
    private final StudentManagementMapper mapper() {
        return null;
    };

    @Override
    public void process(StudentManagement form) {
    }
}
