package com.spms.backend.service;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest student);

    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student update(Long id, StudentRequest student);
    void delete(Long id);

}
