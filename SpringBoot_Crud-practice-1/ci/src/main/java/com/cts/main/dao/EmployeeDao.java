package com.cts.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.main.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
