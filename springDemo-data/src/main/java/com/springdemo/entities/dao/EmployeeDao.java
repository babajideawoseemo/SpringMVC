package com.springdemo.entities.dao;

import java.util.List;

import com.springdemo.entities.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployee();
	
	public Employee getEmployeeById(int id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
}
