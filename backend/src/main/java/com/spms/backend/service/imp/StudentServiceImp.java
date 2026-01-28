package com.spms.backend.service.imp;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.exception.ResourceNotFoundException;
import com.spms.backend.model.Student;
import com.spms.backend.repository.StudentRepository;
import com.spms.backend.service.StudentService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentRequest request) {
        Student student = new Student(
                request.getName(),
                request.getEmail(),
                request.getCourse(),
                request.getGpa()
        );
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id " + id));
    }

    @Override
    public Student update(Long id, StudentRequest request) {
        Student existing = getStudentById(id);
        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setCourse(request.getCourse());
        existing.setGpa(request.getGpa());
        return studentRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    // 🔥 Pagination + optional search
    @Override
    public Page<Student> getStudents(String search, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        if (search == null || search.trim().isEmpty()) {
            return studentRepository.findAll(pageable);
        }

        return studentRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        search, search, pageable);
    }

    // 🔍 Search ONLY (NO findAll fallback)
    @Override
    public List<Student> search(String query) {
        return studentRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query);
    }
}
