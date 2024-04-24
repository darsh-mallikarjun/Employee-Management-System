package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeServiceImpl {

	public List<Employee> findAll();
	
	Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
