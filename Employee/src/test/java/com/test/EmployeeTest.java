package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import com.model.Employee;
import com.service.EmployeeService;
import com.repo.EmployeeRepo;

@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
	
	//Add the appropriate annotation
	@Mock
	EmployeeRepo repo;
	
	//Add the appropriate annotation
	@InjectMocks
	EmployeeService service;
	
	private Employee employee1;
	private Employee employee2;
	private List<Employee> employeeList;
	
	@BeforeEach
	public void setup() {
		employee1 = new Employee(101, "John Doe", "john@example.com", 50000.0);
		employee2 = new Employee(102, "Jane Smith", "jane@example.com", 60000.0);
		
		employeeList = new ArrayList<>();
		employeeList.add(employee1);
		employeeList.add(employee2);
	}
	
	//Test the addEmployee method in EmployeeService class
	@Test
	public void test1AddEmployee() {
	    
		// Fill the code
		// Use when().thenReturn() method
		when(repo.addEmployeeToList(employee1)).thenReturn(1);
		int result = service.addEmployee(employee1);
		assertEquals(1,result);
		
	}
	
	//Test the deleteEmployee method in EmployeeService class
	@Test
	public void test2DeleteEmployee() {
		service.deleteEmployee(employee1);
		// Fill the code
		//Use verify() method	
		verify(repo).deleteEmployeeFromList(employee1);
	}
	
	//Test the fetchEmployeeById method in EmployeeService class for a valid employeeId
	@Test
	public void test3FetchEmployeeByEmployeeId() {
		when(repo.getEmployeeByEmployeeId(101)).thenReturn(employee1);
		Employee result = service.fetchEmployeeById(101);
		// Fill the code
		// Use when().thenReturn() method
		assertNotNull(result);
		assertEquals(101, result.getEmployeeId());
		assertEquals("John Doe", result.getEmployeeName());
	}
	
	//Test the fetchEmployeeById method in EmployeeService class for an invalid employeeId
	@Test
	public void test4FetchEmployeeByEmployeeIdWhenNull() {
		when(repo.getEmployeeByEmployeeId(999)).thenReturn(null);
		// Fill the code
		// Use assertThrows
		assertThrows(NullPointerException.class, () -> {
			service.fetchEmployeeById(999);
		});
	}
	
	//Test the fetchEmployee method in EmployeeService class
	@Test
	public void test5FetchEmployee() {
		when(repo.getEmployee()).thenReturn(employeeList);
		// Fill the code
		// Use when().thenReturn() method
		List<Employee> result = service.fetchEmployee();
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals(employee1, result.get(0));
		assertEquals(employee2, result.get(1));
	}
	
}
