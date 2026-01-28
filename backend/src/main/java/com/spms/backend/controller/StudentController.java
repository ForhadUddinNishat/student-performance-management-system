package com.spms.backend.controller;

import com.spms.backend.dto.StudentRequest;
import com.spms.backend.model.Student;
import com.spms.backend.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentRequest request) {
        return ResponseEntity.ok(studentService.createStudent(request));
    }

    // GET ALL + PAGINATION + SEARCH
    @GetMapping
    public ResponseEntity<Page<Student>> getAll(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(
                studentService.getStudents(search, page, size, sortBy)
        );
    }

    // 🔍 SEARCH ONLY (FIXED — no conflict with /{id})
    @GetMapping("/search")
    public ResponseEntity<List<Student>> search(
            @RequestParam("query") String query
    ) {
        return ResponseEntity.ok(studentService.search(query));
    }

    // GET BY ID (must be AFTER /search)
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(
            @PathVariable Long id,
            @RequestBody StudentRequest request
    ) {
        return ResponseEntity.ok(studentService.update(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
