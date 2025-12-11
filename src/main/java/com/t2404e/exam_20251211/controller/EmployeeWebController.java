package com.t2404e.exam_20251211.controller;

import com.t2404e.exam_20251211.entity.Employee;
import com.t2404e.exam_20251211.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    // 1. Hiển thị Danh sách Nhân viên (Sử dụng getEmployees)
    // Ánh xạ tới http://localhost:8080/employees
    @GetMapping
    public String listEmployees(Model model) {
        // Lấy tất cả nhân viên từ Service và gửi vào model
        model.addAttribute("employees", employeeService.getEmployees());

        // Trả về tên view: "employee-list.html"
        return "employee-list";
    }

    // 2. Hiển thị Form Thêm Nhân viên
    // Ánh xạ tới http://localhost:8080/employees/new
    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        // Tạo một đối tượng Employee rỗng để liên kết với form
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        // Trả về tên view: "employee-form.html"
        return "employee-form";
    }

    // 3. Xử lý việc Thêm Nhân viên (Sử dụng addEmployees)
    @PostMapping
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        // Lưu nhân viên mới vào database
        employeeService.addEmployee(employee);

        // Chuyển hướng về trang danh sách nhân viên sau khi thêm thành công
        return "redirect:/employees";
    }
}
