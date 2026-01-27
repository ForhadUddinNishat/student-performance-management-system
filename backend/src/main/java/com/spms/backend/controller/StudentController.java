package com.spms.backend.controller;

import com.spms.backend.model.Student;
import com.spms.backend.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudent();

    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id){
        return studentService.getStudentById(id);

    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student){
        return studentService.update(id,student);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }

}
