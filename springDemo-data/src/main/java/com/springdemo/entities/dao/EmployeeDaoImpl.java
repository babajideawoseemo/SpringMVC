package com.springdemo.entities.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger =Logger.getLogger(EmployeeDaoImpl.class.getName());
	
	//private Session currentSession = sessionFactory.getCurrentSession();
	
	@Transactional
	public void addEmployee(Employee employee) {
		
		logger.info("Getting current session");
		Session currentSession = sessionFactory.getCurrentSession();
		
//		logger.info("starting a transaction");
//		currentSession.beginTransaction();
		
		logger.info("Storing employee in the database" + employee.toString());
		currentSession.save(employee);
		
		logger.info("Successful, committing transaction");
//		currentSession.getTransaction().commit();
	}
}
