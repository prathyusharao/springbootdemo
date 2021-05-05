package com.sampleproject.springbootdemo.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sampleproject.springbootdemo.dao.EmployeeDao;
import com.sampleproject.springbootdemo.entity.Employee;
import com.sampleproject.springbootdemo.entitytwo.EmployeeDetails;
import com.sampleproject.springbootdemo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired
   private EmployeeDao employeeDao;
	
@Override
public Employee saveEmployee(Employee employee) 
{
	
	return employeeDao.save(employee);
}

@Override
public List<Employee> saveEmployees(List<Employee> employees) 
{	
	return employeeDao.saveAll(employees);
}

@Override
public List<Employee> findAllEmployeeByNameAsc() 
{
	return employeeDao.findAllEmployeeByNameAsc(Sort.by(Sort.Direction.ASC, "Employee_fname"));	
}

@Override
public Employee updateEmployee(Employee employee)
{
	
	return employeeDao.save(employee);
}

@Override
public String deleteEmployee(int Employee_Id) 
{
	 employeeDao.deleteById(Employee_Id);
	 return "Employee removed... with id: " +Employee_Id;
}

@Override
public String deleteAllEmployees() 
{
		employeeDao.deleteAll();
	return "All Employees Deleted Successfully...";	
}

@Override
public void deleteSomeEmployees(Integer[] ids) {
	for(Integer id: ids)
	{
		deleteEmployee(id);
	}
	
}











  
}