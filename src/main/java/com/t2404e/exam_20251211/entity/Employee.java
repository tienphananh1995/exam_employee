package com.t2404e.exam_20251211.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Đánh dấu đây là một JPA Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Thuộc tính id

    private String name; // Thuộc tính name
    private Double salary; // Thuộc tính salary

    // Constructors (No-arg và All-arg)
    public Employee() {}

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}