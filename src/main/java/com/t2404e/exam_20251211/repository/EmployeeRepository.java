package com.t2404e.exam_20251211.repository;

import com.t2404e.exam_20251211.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
