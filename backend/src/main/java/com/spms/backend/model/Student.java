package com.spms.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
    private Double gpa;

    public Student() {}

    public Student(String name, String email, String course, Double gpa) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.gpa = gpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Double getGpa() { return gpa; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCourse(String course) { this.course = course; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
}
