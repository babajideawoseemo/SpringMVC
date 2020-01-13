package com.springdemo.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springdemo.entities.Employee;


@ContextConfiguration("classpath:/springdemo-service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		
		employeeService = mock(EmployeeService.class);
	}

	@Test
	public void employeeExistsTest() {
		
		assertNotNull(employeeService);
		
	}
	
	@Test
	public void addEmployeeTest() {
		
		Employee employee = new Employee("Peter", "Brand", "peter@gmail.com");
		
		doNothing().when(employeeService).addEmployee(isA(Employee.class));
		
		employeeService.addEmployee(employee);
		
		verify(employeeService, times(1)).addEmployee(employee);
		
		
	}

}
