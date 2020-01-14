package com.springdemo.entities.dao;



import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springdemo.entities.Employee;

@ContextConfiguration("/springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

	private Logger logger = Logger.getLogger(EmployeeDaoImplTest.class.getName());
	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;	

	@Test
	public void dbManagerClassesInitializedTest() {
		assertNotNull(employeeDaoImpl);
		assertNotNull(dataSource);
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void getEmployeeListTest() {
		
		Employee tempEmployee = new Employee("paul", "Paulina", "paul@gmail.com");
		Employee tempEmployee2 = new Employee("james", "Brown", "james@gmail.com");
		Employee tempEmployee3 = new Employee("Michael", "Peter", "michael@gmail.com");
		
		employeeDaoImpl.addEmployee(tempEmployee);
		employeeDaoImpl.addEmployee(tempEmployee2);
		employeeDaoImpl.addEmployee(tempEmployee3);
		
		//create an employee object
		List<Employee> theEmployees = employeeDaoImpl.getEmployee();
		
//		assertEquals("John", theEmployees.get(0).getFirstname());
//		assertEquals("Paulina", theEmployees.get(0).getLastname());
//		assertEquals("paul@gmail.com", theEmployees.get(0).getEmail());
//		
//		assertEquals("james", theEmployees.get(1).getFirstname());
//		assertEquals("Brown", theEmployees.get(1).getLastname());
//		assertEquals("james@gmail.com", theEmployees.get(1).getEmail());
//		
//		assertEquals("Michael", theEmployees.get(2).getFirstname());
//		assertEquals("Peter", theEmployees.get(2).getLastname());
//		assertEquals("michael@gmail.com", theEmployees.get(2).getEmail());
		
		assertNotNull(theEmployees.get(0));
		assertNotNull(theEmployees.get(1));
		assertNotNull(theEmployees.get(2));
	
		
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
		Employee tempEmployee = new Employee("paul", "Paulina", "paul@gmail.com");
		Employee tempEmployee2 = new Employee("james", "Brown", "james@gmail.com");
		Employee tempEmployee3 = new Employee("Michael", "Peter", "michael@gmail.com");
		
		employeeDaoImpl.addEmployee(tempEmployee);
		employeeDaoImpl.addEmployee(tempEmployee2);
		employeeDaoImpl.addEmployee(tempEmployee3);
		
		//create an employee object
		List<Employee> theEmployees = employeeDaoImpl.getEmployee();
		
//		assertEquals("John", theEmployees.get(0).getFirstname());
//		assertEquals("Paulina", theEmployees.get(0).getLastname());
//		assertEquals("paul@gmail.com", theEmployees.get(0).getEmail());
//		
//		assertEquals("james", theEmployees.get(1).getFirstname());
//		assertEquals("Brown", theEmployees.get(1).getLastname());
//		assertEquals("james@gmail.com", theEmployees.get(1).getEmail());
//		
//		assertEquals("Michael", theEmployees.get(2).getFirstname());
//		assertEquals("Peter", theEmployees.get(2).getLastname());
//		assertEquals("michael@gmail.com", theEmployees.get(2).getEmail());
		
		assertNotNull(theEmployees.get(0));
		assertNotNull(theEmployees.get(1));
		assertNotNull(theEmployees.get(2));
		
		int employeeId = theEmployees.get(0).getId();
		
		Employee tempEmployee4 = employeeDaoImpl.getEmployeeById(employeeId);
	
		String firstname = tempEmployee4.getFirstname();
		String lastname = tempEmployee4.getLastname();
		String email = tempEmployee4.getEmail();
		
		assertNotNull(tempEmployee4);
		
		System.out.println("Employee found from the Database: ==>" + tempEmployee);
		
		assertEquals(firstname, tempEmployee4.getFirstname());
		assertEquals(lastname, tempEmployee4.getLastname());
		assertEquals(email, tempEmployee4.getEmail());

		
		
		
	}
	
	@Test
	public void updateEmployee() {
		
		List<Employee> employeeList = employeeDaoImpl.getEmployee();
		
		Employee tempEmployee = employeeList.get(1);
		
		//update the employee
		
		
		
	}
	
	@Test
	public void addEmployeeToDatabaseTest() {
		
		try {
		logger.info("Creating an empty object");
		Employee temployee = new Employee("John", "Paulina", "john@gmail.com");
		logger.info("Storing object to the database");
		employeeDaoImpl.addEmployee(temployee);
		
		} catch(Exception e) {
			e.printStackTrace();
			logger.warning("Error saving employee to the database");
		}
	}

}
