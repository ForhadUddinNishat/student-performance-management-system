package com.spms.backend.service;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.dto.StudentResponse;
import com.spms.backend.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(StudentRequest request);

    StudentResponse getStudentById(Long id);

    StudentResponse update(Long id, StudentRequest request);

    void delete(Long id);

    Page<StudentResponse> getStudents(String search, int page, int size, String sortBy);

    List<StudentResponse> search(String query);
}
