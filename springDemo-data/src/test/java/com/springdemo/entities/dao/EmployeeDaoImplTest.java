package com.springdemo.entities.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hibernate.SessionFactory;
import java.util.logging.Logger;
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
