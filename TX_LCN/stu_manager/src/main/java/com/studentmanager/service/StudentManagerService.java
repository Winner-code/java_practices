package com.studentmanager.service;

import com.pojo.Student;

public interface StudentManagerService {
    Student register(Student student);
    Student findById(Long id);
}
