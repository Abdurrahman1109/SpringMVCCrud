package com.example.SpringMVCCrud.controller;

import com.example.SpringMVCCrud.entity.Employee;
import com.example.SpringMVCCrud.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeServiceImpl employeeServiceImpl;
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl){
        this.employeeServiceImpl=employeeServiceImpl;
    }
    @GetMapping("/employees")
    public String listAllEmployee(Model model){
        List<Employee> list=employeeServiceImpl.listAll();
        model.addAttribute("employees",list);
        return "employee/emp-list";
    }
    @GetMapping("/add_employee")
    public String showForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee/add_employee";
    }
    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        employeeServiceImpl.addEmployee(employee);
        System.out.println(employee);
        return "redirect:/employees";
    }

    @GetMapping("/showUpdateForm")
    public String updateEmployee(@RequestParam("empId")int id,Model model){
        Employee emp=employeeServiceImpl.findById(id);
        model.addAttribute("employee",emp);
        return "employee/add_employee";
    }

    @GetMapping("/delEmployee")
    public String removeEmployee(@RequestParam ("empId") int id){
        Employee employee=employeeServiceImpl.deleteById(id);
        return "redirect:/employees";
    }
}
