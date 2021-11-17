package com.cts.main.controller;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.main.ExceptionHandling.EmployeeNotFoundException;
import com.cts.main.model.Employee;
import com.cts.main.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private MessageSource messageSource;
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveToDb(@Valid @RequestBody Employee emp) {// Adding validation by @Valid

		empService.saveToDb(emp);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployee() {
		List<Employee> emp = empService.getAll();
		if (emp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee not Found");

		} else {
			return emp;
		}

	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public EntityModel<Employee> getEmployeeById(@PathVariable("id") int id) {

		java.util.Optional<Employee> emp = empService.getEmpById(id);

		if (!emp.isPresent())
			throw new EmployeeNotFoundException("Employee not found of id :" + id);

		// Implementing HATEOUS (links)
		EntityModel<Employee> resource = EntityModel.of(emp.get());
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllEmployee());

		resource.add(link.withRel("all-emp"));
		return resource;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmp(@PathVariable("id") int id) {
		Optional<Employee> emp=empService.findById(id);
		
		if(emp.isPresent()) {
			
			empService.deleteEmp(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}else {
			
			throw new EmployeeNotFoundException("Employee not found:"+id);
		}
		

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmp(@PathVariable("id") int id, @RequestBody Employee emp) {
		Optional<Employee> emp1=empService.findById(id);
		
		if(emp1.isPresent()) {
			
			emp.setId(id);
			empService.saveToDb(emp);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}else {
			
			throw new EmployeeNotFoundException("Employee not found:"+id);
		}
		
	}
	
	
	//Implementing Internationalization
	
	@GetMapping("/hello_I18")
	public String getI18(@RequestHeader(name="Accept-Language",required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null ,locale);
	}
 
}
