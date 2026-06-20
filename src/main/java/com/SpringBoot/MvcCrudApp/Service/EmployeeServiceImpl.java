package com.SpringBoot.MvcCrudApp.Service;

import com.SpringBoot.MvcCrudApp.DAO.EmployeeDAOImpl;
import com.SpringBoot.MvcCrudApp.DAO.EmployeeRepository;
import com.SpringBoot.MvcCrudApp.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service layer to implement Service Facade design pattern. It delegates calls to DAO/Repository underneath

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // define EmployeeRepository field
    EmployeeRepository employeeRepository;

    // define constructor for injection
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // using Optional (Java 8 feature)
        Optional<Employee> tempEmployee = employeeRepository.findById(theId);

        Employee dbEmployee = null;

        // throw exception if null else return employee
        if (tempEmployee == null) {
            throw  new RuntimeException("Employee not found with ID " + theId);
        }
        else {
            dbEmployee = tempEmployee.get();
        }

        return dbEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
