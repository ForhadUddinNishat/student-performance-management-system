package com.spms.backend.dto;

import jakarta.validation.constraints.*;

public class StudentRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Course is required")
    private String course;

    @NotNull(message = "GPA is required")
    @DecimalMin(value = "0.0", message = "GPA must be >= 0.0")
    @DecimalMax(value = "4.0", message = "GPA must be <= 4.0")
    private Double gpa;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
