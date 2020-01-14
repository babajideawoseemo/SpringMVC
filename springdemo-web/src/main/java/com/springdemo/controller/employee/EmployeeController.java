package com.springdemo.controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springdemo.entities.Employee;
import com.springdemo.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;

	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee tempEmployee) {
		
		employeeServiceImpl.addEmployee(tempEmployee);
		
		return "employee-list";
		
	}
	
	@GetMapping("/showform")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
}
