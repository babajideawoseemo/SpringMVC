package com.springdemo.entities.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
	logger.info("starting a transaction");
//		currentSession.beginTransaction();
		
		logger.info("Storing employee in the database" + employee.toString());
		currentSession.save(employee);
		
		logger.info("Successful, committing transaction");
//		currentSession.getTransaction().commit();
	}
	
	@Transactional
	public List<Employee> getEmployee() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		logger.info("Querying list of employees from the database");
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employeeList = theQuery.getResultList();
		
		return employeeList;
		
	}
	
	@Transactional
	public Employee getEmployeeById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Employee theEmployee = currentSession.get(Employee.class, id);
		
		return theEmployee;

	}
	
	@Transactional
	public void updateEmployee(Employee theEmployee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(theEmployee);

	}
	
	@Transactional
	public void deleteEmployee(Employee theEmployee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.delete(theEmployee);

	}
	
}
