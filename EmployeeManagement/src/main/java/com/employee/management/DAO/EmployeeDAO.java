package com.employee.management.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.model.Employee;

public interface EmployeeDAO extends JpaRepository <Employee , Integer> {

}
