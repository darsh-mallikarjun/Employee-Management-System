package com.employee.management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeServiceImpl;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeServiceImpl employeeserviceimpl;

	public EmployeeController(EmployeeServiceImpl theemployeeserviceimpl) {
		employeeserviceimpl = theemployeeserviceimpl;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model themodel) {
		
		List<Employee> theEmployee = employeeserviceimpl.findAll();
		
		themodel.addAttribute("employees", theEmployee);
		
		return "employees/list-employee";	
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model themodel){
		
		Employee theEmployee = new Employee();
		 
		themodel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdate(@RequestParam("employeeId") int theId,Model themodel) {
		
		Employee theemployee = employeeserviceimpl.findById(theId);
		
		
		themodel.addAttribute("employee", theemployee);
		
		
		return "employees/employee-form";
		
	}
	@GetMapping("/showFormForDelete")
	public String showDelete(@RequestParam("employeeId") int theId,Model themodel) {
		
       employeeserviceimpl.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeserviceimpl.save(theEmployee);
		
		return "redirect:/employees/list";
		
	}
	
	
}
