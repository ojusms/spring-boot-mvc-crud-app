package com.SpringBoot.MvcCrudApp.DAO;

import com.SpringBoot.MvcCrudApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // provides some methods out of the box for DB interactions
}
