package com.springdemo.controller.employee.test;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springdemo.controller.employee.EmployeeController;
import com.springdemo.service.EmployeeService;


@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-mvc-crud-demo-servlet.xml")
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;

	@Mock
	private EmployeeService employeeServiceImpl;
	
	@Before
	public void tearDown() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(EmployeeController.class).build();

	}

	@Test
	public void test() {
		assertNotNull(employeeServiceImpl);
	}

	@Test
	public void getFormRequestTest() {
		
//	    this.mockMvc.perform(post("/greetWithPost")).andDo(print())
//	      .andExpect(status().isOk()).andExpect(content()
//	      .contentType("application/json;charset=UTF-8"))
//	      .andExpect(jsonPath("$.message").value("Hello World!!!"));
		try {
			this.mockMvc.perform(post("/showform")).andDo(print());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
