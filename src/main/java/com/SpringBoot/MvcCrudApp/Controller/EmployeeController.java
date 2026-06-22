package com.SpringBoot.MvcCrudApp.Controller;


import com.SpringBoot.MvcCrudApp.Entity.Employee;
import com.SpringBoot.MvcCrudApp.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // define field for EmployeeService
    EmployeeService employeeService;

    // define constructor for dependency injection.
    // @Autowired annotation is optional since there is only one constructor
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // retrieve list of employees from database
        List<Employee> employees = employeeService.findAll();

        // add employees to Model with addAttribute()
        theModel.addAttribute("employees", employees);

        return "list-employees";
    }

    // add mapping for "/showFormForAdd"

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create object of Employee to bind form data
        Employee theEmployee = new Employee();

        // add Employee object to Model with addAttribute()
        theModel.addAttribute("employee",theEmployee);

        return "employee-form";
    }
}
