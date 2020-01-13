package com.springdemo.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@ContextConfiguration(locations = "classpath:springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class DbConnectionManagerTest {

	@Autowired
	private ComboPooledDataSource dataSource;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dataSourceInitializedTest() {
		assertNotNull(dataSource);
	}
	
	@Test
	public void dbConnectionManagerExistTest() {
		
		String username = "springdemouser";
		String password = "spring_Demo1";
		String jdbcUrl = "jdbc:mysql://localhost:3306/springDemoDB?useSSL=false&amp;serverTimezone=UTC&allowPublicKeyRetrieval=true";
		
		try {
			
			Connection mycon = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection successful" + jdbcUrl );
			
		} catch(SQLException e) {
			
		}
		
	}

}
