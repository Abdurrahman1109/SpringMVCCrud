package com.example.SpringMVCCrud.service;

import com.example.SpringMVCCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List listAll();
    public Employee addEmployee(Employee employee);
    public Employee findById(int id);
    public Employee deleteById(int id);
}
