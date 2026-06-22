package com.SpringBoot.MvcCrudApp.DAO;

import com.SpringBoot.MvcCrudApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // provides some methods out of the box for DB interactions

    // custom method for list of employees sorted by last name in asc
    public List<Employee> findAllByOrderByLastNameAsc();
}
