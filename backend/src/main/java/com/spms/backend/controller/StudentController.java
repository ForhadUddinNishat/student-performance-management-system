package com.spms.backend.controller;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.model.Student;
import com.spms.backend.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ser.jdk.JDKKeySerializers;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create
    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(request));
    }

    //read by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));

    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id, @Valid @RequestBody StudentRequest request){
        return ResponseEntity.ok(studentService.update(id, request));
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Search + pagination
    @GetMapping
    public ResponseEntity<Page<Student>> getAll(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy

    ){
        return ResponseEntity.ok(studentService.getStudents(search, page, size, sortBy));

    }


}
