package com.t2404e.exam_20251211.service;

import com.t2404e.exam_20251211.entity.Employee;
import com.t2404e.exam_20251211.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 1. getEmployees: Lấy tất cả nhân viên (02.0 Marks)
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // 2. addEmployees: Thêm một nhân viên mới (02.0 Marks)
    public Employee addEmployee(Employee employee) {
        // ID phải được đặt là null để database tự sinh (nếu sử dụng auto-increment)
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    // 3. updateEmployee: Cập nhật thông tin nhân viên (02.0 Marks)
    public Employee updateEmployee(Employee employee) {
        // Kiểm tra xem Employee có tồn tại không trước khi cập nhật
        if (employee.getId() == null) {
            throw new IllegalArgumentException("Employee ID is required for update.");
        }

        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());

        if (existingEmployee.isPresent()) {
            // Thực hiện cập nhật
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee with ID " + employee.getId() + " not found.");
        }
    }
}
