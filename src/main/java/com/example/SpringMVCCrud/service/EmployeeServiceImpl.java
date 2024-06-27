package com.example.SpringMVCCrud.service;

import com.example.SpringMVCCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EntityManager entityManager;

    public  EmployeeServiceImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }
    @Override
    public List<Employee> listAll() {
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        List<Employee> r=query.getResultList();
        return r;
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        Employee newEmpl=entityManager.merge(employee);
        return newEmpl;
    }

    @Override
    public Employee findById(int id) {
        Employee r1=entityManager.find(Employee.class,id);
        return r1;
    }

    @Override
    @Transactional
    public Employee deleteById(int id) {
        Employee removeEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(removeEmployee);
        return removeEmployee;
    }
}
