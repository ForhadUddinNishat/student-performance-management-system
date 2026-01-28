package com.spms.backend.service;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentRequest request);

    Student getStudentById(Long id);

    Student update(Long id, StudentRequest request);

    void delete(Long id);

    // Pagination + search
    Page<Student> getStudents(String search, int page, int size, String sortBy);

    // Search ONLY
    List<Student> search(String query);
}
