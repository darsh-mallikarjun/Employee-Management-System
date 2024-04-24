package com.employee.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.DAO.EmployeeDAO;
import com.employee.management.model.Employee;

@Service
public class EmployeeService implements EmployeeServiceImpl {

	private EmployeeDAO employeeDAO;

	
	@Autowired
	public EmployeeService(EmployeeDAO theemployeeDAO) {
		super();
		this.employeeDAO = theemployeeDAO;
	}


	@Override
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}


	@Override
	public Employee findById(int theId) {
		 Optional<Employee> result = employeeDAO.findById(theId);

	        Employee theEmployee = null;

	        if (result.isPresent()) {
	            theEmployee = result.get();
	        }
	        else {
	            // we didn't find the employee
	            throw new RuntimeException("Did not find employee id - " + theId);
	        }

	        return theEmployee;
	}


	@Override
	public Employee save(Employee theEmployee) {
		
		return employeeDAO.save(theEmployee);
	}


	@Override
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}
	
	
}
