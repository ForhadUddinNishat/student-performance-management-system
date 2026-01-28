package com.spms.backend.dto;

public class StudentResponse {
    private long id;
    private String name;
    private String email;
    private String course;
    private double gpa;

    public StudentResponse(long id, String name, String email, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.gpa = gpa;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public double getGpa() {
        return gpa;
    }
}
