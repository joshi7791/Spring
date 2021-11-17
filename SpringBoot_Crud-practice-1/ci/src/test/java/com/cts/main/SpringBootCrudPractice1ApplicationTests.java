package com.cts.main;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.main.dao.EmployeeDao;
import com.cts.main.model.Employee;
import com.cts.main.service.EmployeeServiceImpl;

@SpringBootTest
class SpringBootCrudPractice1ApplicationTests {

	@InjectMocks
	private EmployeeServiceImpl service;
	
	/*
	 * @Mock private EmployeeDao dao;
	 */
	
	@Spy
	private EmployeeDao dao;
	
	
	@Test
	@Disabled
	public void TesGetAllMethod() {
		
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("abc");
		e1.setAddress("pune");
		e1.setUsername("a");
		e1.setPassword("a");
		
		Employee e2=new Employee();
		e2.setId(1);
		e2.setName("abcde");
		e2.setAddress("mumbai");
		e2.setUsername("b");
		e2.setPassword("b");
		
		List<Employee> empList=new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		
		when(dao.findAll()).thenReturn(empList);
		
		List<Employee> emp=service.getAll();
		
		//System.out.println(emp.get(0).getName());
		
		assertEquals(2, emp.size());
		
		
	}
	
	@Test
	@Disabled
	public void testForGetEmpByIdMethid() {
		
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("abc");
		e1.setAddress("pune");
		e1.setUsername("a");
		e1.setPassword("a");
		
		
		when(dao.findById(1)).thenReturn(Optional.of(e1));
		
		Optional<Employee> opEmp=service.getEmpById(1);
		
		assertEquals(e1,opEmp.get());
		
		
	}
	
	
	@Test
	public void testForSaveMethod() {
		
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("abc");
		e1.setAddress("pune");
		e1.setUsername("a");
		e1.setPassword("a");
		

		service.saveToDb(e1);
		
		verify(dao, times(1)).save(e1);
		  
		
		
	}
	
	
	
	@Test
	public void testForDeleteMethod() {
		
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("abc");
		e1.setAddress("pune");
		e1.setUsername("a");
		e1.setPassword("a");
		

		service.deleteEmp(1);;
		
		verify(dao, times(1)).deleteById(1);;
		  
		
		
	}
	
	
}
