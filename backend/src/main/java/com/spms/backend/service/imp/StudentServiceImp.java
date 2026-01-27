package com.spms.backend.service.imp;

import com.spms.backend.model.Student;
import com.spms.backend.repository.StudentRepository;
import com.spms.backend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();

    }
    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));

    }

    @Override
    public Student update(Long id, Student student){
        Student existing= getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setGpa(student.getGpa());
        existing.setCourse(student.getCourse());
        return studentRepository.save(existing);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
