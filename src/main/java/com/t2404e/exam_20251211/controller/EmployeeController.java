package com.t2404e.exam_20251211.controller;

import com.t2404e.exam_20251211.entity.Employee;
import com.t2404e.exam_20251211.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") // Endpoint cơ sở cho tất cả các method
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // 1. GET /api/employees: Lấy tất cả nhân viên
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    // 2. POST /api/employees: Thêm một nhân viên mới
    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // 3. PUT /api/employees: Cập nhật nhân viên
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // Xử lý ngoại lệ (Optional: Để nâng cao chất lượng code)
    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException ex) {
        return ex.getMessage();
    }
}