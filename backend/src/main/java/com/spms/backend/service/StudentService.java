package com.spms.backend.service;

import com.spms.backend.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student update(Long id, Student student);
    void delete(Long id);

}
