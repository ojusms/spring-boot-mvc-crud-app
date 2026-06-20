package com.SpringBoot.MvcCrudApp.Service;

import com.SpringBoot.MvcCrudApp.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
