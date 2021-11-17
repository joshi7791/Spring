package com.cts.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.main.dao.EmployeeDao;
import com.cts.main.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;
	
	
	@Override
	public void saveToDb(Employee emp) {

		empDao.save(emp);
		
		
	}


	@Override
	public List<Employee> getAll() {
		return (List<Employee>) empDao.findAll();
	}


	@Override
	public Optional<Employee> getEmpById(int id) {
		return empDao.findById(id);
	}


	@Override
	public void deleteEmp(int id) {
		empDao.deleteById(id);
		
	}


	@Override
	public Optional<Employee> findById(int id) {
		return empDao.findById(id);
	}

}
