package com.spms.backend.service.imp;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.dto.StudentResponse;
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
    private StudentResponse map(Student s){
        return new StudentResponse(
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getCourse(),
                s.getGpa()
        );
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student student = new Student(
                request.getName(),
                request.getEmail(),
                request.getCourse(),
                request.getGpa()
        );
        return map(studentRepository.save(student));
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student s =studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        return map(s);
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student existing = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setCourse(request.getCourse());
        existing.setGpa(request.getGpa());
        return map(studentRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<StudentResponse> getStudents(String search, int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        Page<Student> result= (search == null || search.isBlank()) ? studentRepository.findAll(pageable) :
                studentRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(search, search, pageable);
        return result.map(this::map);
    }

    // 🔍 Search ONLY (NO findAll fallback)
    @Override
    public List<StudentResponse> search(String query) {
        return studentRepository
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query)
                .stream().map(this::map).toList();
    }
}
