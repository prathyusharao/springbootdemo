package com.sampleproject.springbootdemo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sampleproject.springbootdemo.dbdetails.DBDetails;
import com.sampleproject.springbootdemo.entity.Employee;
import com.sampleproject.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController
{	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees)
	{
		return employeeService.saveEmployees(employees);
	}
	
	@GetMapping("/employeesbyasc")
	public List<Employee> findAllEmployees()
	{
		return employeeService.findAllEmployeeByNameAsc();	
	}
		
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee)
	{
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/delete/{Employee_Id}")
	public String deleteEmployee(@PathVariable int Employee_Id)
	{
		return employeeService.deleteEmployee(Employee_Id);
	}
	
	@DeleteMapping("/deleteall")  
	private String deleteAllEmployees()   
	{  	
	   return employeeService.deleteAllEmployees();  
	}
	
	@DeleteMapping("/deletes/{ids}")
	private void deleteSomeEmployees(@PathVariable Integer[] ids)
	{
		employeeService.deleteSomeEmployees(ids);
		
	}
	
	@Autowired
	private DBDetails dbDetails;
	
	
	@GetMapping("/url")
	public String getDBUrl()
	{
		return dbDetails.getUrl();
		
	}
	
	@GetMapping("/username")
	public String getDBUsername()
	{
		return dbDetails.getUsername();
		
	}
	
	@GetMapping("/password")
	public String getDBPassword()
	{
		return dbDetails.getPassword();
		
	}
	
	@GetMapping("/driverClassName")
	public String getDBDriverClassName()
	{
		return dbDetails.getDriverClassName();
		
	}
}

