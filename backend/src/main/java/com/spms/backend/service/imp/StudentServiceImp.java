package com.spms.backend.service.imp;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.exception.ResourceNotFoundException;
import com.spms.backend.model.Student;
import com.spms.backend.repository.StudentRepository;
import com.spms.backend.service.StudentService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student createStudent(StudentRequest request){
        Student stu= new Student(
                request.getName(),
                request.getEmail(),
                request.getCourse(),
                request.getGpa()
        );
        return studentRepository.save(stu);
    }
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id "+id));

    }

    @Override
    public Student update(Long id, StudentRequest request){
        Student existing= getStudentById(id);
        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setGpa(request.getGpa());
        existing.setCourse(request.getCourse());
        return studentRepository.save(existing);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }


    public Page<Student> getStudents(String search, int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        if(search == null || search.isBlank()){
            return studentRepository.findAll(pageable);
        }
        return studentRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(search, search, pageable);
    };



}
