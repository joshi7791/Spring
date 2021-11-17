package com.cts.main.service;

import java.util.List;
import java.util.Optional;

import com.cts.main.model.Employee;

public interface EmployeeService {

	void saveToDb(Employee emp);

	List<Employee> getAll();

	Optional<Employee> getEmpById(int id);

	void deleteEmp(int id);

	Optional<Employee> findById(int id);

}
