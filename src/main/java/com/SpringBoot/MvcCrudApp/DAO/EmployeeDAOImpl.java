package com.SpringBoot.MvcCrudApp.DAO;

import com.SpringBoot.MvcCrudApp.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for EntityManager

    EntityManager entityManager;

    // define constructor for injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute query and store result
        List<Employee> employees = theQuery.getResultList();

        // return result
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // find employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee tempEmployee = entityManager.merge(theEmployee);

        // return saved employee with updated ID
        return tempEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee
        Employee tempEmployee = entityManager.find(Employee.class, theId);

        // delete employee
        entityManager.remove(tempEmployee);
    }
}
