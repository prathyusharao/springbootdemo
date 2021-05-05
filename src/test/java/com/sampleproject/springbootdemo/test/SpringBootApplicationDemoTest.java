//package com.sampleproject.springbootdemo.test;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.sampleproject.springbootdemo.SpringBootApplicationDemo;
//import com.sampleproject.springbootdemo.controller.EmployeeController;
//import com.sampleproject.springbootdemo.dao.EmployeeDao;
//import com.sampleproject.springbootdemo.dbdetails.DBDetails;
//import com.sampleproject.springbootdemo.entity.Employee;
//import com.sampleproject.springbootdemo.entitytwo.EmployeeDetails;
//import com.sampleproject.springbootdemo.service.EmployeeService;
//import com.sampleproject.springbootdemo.service.impl.EmployeeServiceImpl;
//
////@ExtendWith(MockitoExtension.class)

// main class starts here.
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootApplicationDemoTest {
//
//    @InjectMocks
//    private EmployeeController employeeController;
//    @Autowired
//	private EmployeeService employeeService;
//	@Autowired
//	private DBDetails dbDetails;
//	@MockBean
//	private EmployeeDao employeeDao;
//	
//	@Before
//	    public void init() {
//	        MockitoAnnotations.initMocks(this);
//	    }
//	
//	@Test
//	public void main()
//	{
//		SpringBootApplicationDemo.main(new String[] {});
//	}
//	
//	@Test
//	public void addEmployeeTest()
//	{
//		Employee employee = new Employee(1, "RamyaSree", "Karanam", "ramyasree@xyz.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Andhra Pradesh","India"));	
//		when(employeeDao.save(employee)).thenReturn(employee);
//	    assertEquals(employee, employeeService.saveEmployee(employee));
//	    
//	}
//	
//	@Test
//	public void getAllEmployeesTest()
//	{
//		List<Employee> emp = new ArrayList<Employee>();
//		Employee emp1 = new Employee(1, "RamyaSree", "Karanam", "ramyasree@abc.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Andhra Pradesh","India"));
//		Employee emp2= new Employee(2, "GokulKrishna", "Teppala", "gpkulkrishnat@xyz.com", "9293768692", "Male", new EmployeeDetails(1,9,"D.no 58/27, Jyoti Nagar, Visakhapatnam","530018","Andhra Pradesh","India"));	
//		emp.add(emp1);
//	    emp.add(emp2);
//		when(employeeDao.findAllEmployeeByNameAsc(Sort.by(Sort.Direction.ASC, "Employee_fname"))).thenReturn(emp);
//		List<Employee> employee = employeeService.findAllEmployeeByNameAsc();
//		assertEquals(2, employee.size());
//	    verify(employeeDao,times(1)).findAllEmployeeByNameAsc(Sort.by(Sort.Direction.ASC, "Employee_fname"));
//	}
//	
//	
//	@Test
//	public void addEmployeesTest()
//	{
//		List<Employee> employees = new ArrayList<Employee>();
//		Employee emp1 = new Employee(1, "RamyaSree", "Karanam", "ramyasree@abc.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Andhra Pradesh","India"));
//		Employee emp2= new Employee(2, "GokulKrishna", "Teppala", "gpkulkrishnat@xyz.com", "9293768692", "Male", new EmployeeDetails(1,9,"D.no 58/27, Jyoti Nagar, Visakhapatnam","530018","Andhra Pradesh","India"));
//		
//		employees.add(emp1);
//	    employees.add(emp2);
//	    
//		when(employeeDao.saveAll(employees)).thenReturn(employees);
//		assertEquals(employees, employeeService.saveEmployees(employees));
//	}
//	
//	
//	@Test
//	public void updateTest()
//	{
//		Employee employee = new Employee(1, "RamyaSree", "Karanam", "ramyasreek@xyz.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Telangana","India"));
//	    when(employeeDao.save(employee)).thenReturn(employee);
//	    assertEquals(employee,  employeeService.updateEmployee(employee));
//	}
//	
//	@Test
//	public void deleteByIdTest()
//	{
//		Employee employee = new Employee(1, "RamyaSree", "Karanam", "ramyasreek@abc.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Telangana","India"));
//		employeeService.deleteEmployee(1);
//		verify(employeeDao,times(1)).deleteById(1);
//	}
//	
//	@Test
//	public void deleteAllEmployeesTest()
//	{
//		List<Employee> employees = new ArrayList<Employee>();
//		Employee emp1 = new Employee(1, "RamyaSree", "Karanam", "ramyasree@abc.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Andhra Pradesh","India"));
//		Employee emp2= new Employee(2, "GokulKrishna", "Teppala", "gpkulkrishnat@xyz.com", "9293768692", "Male", new EmployeeDetails(1,9,"D.no 58/27, Jyoti Nagar, Visakhapatnam","530018","Andhra Pradesh","India"));
//		
//		employees.add(emp1);
//	    employees.add(emp2);
//	    
//	    employeeService.deleteAllEmployees();
//	    
//	   verify(employeeDao,times(1)).deleteAll();   
//	}
//	
//	@Test
//	public void deleteSomeEmployeesTest()
//	{
//		List<Employee> employees = new ArrayList<Employee>();
//		Employee emp1 = new Employee(1, "RamyaSree", "Karanam", "ramyasree@abc.com", "9491789808", "Female", new EmployeeDetails(1, 24, "flat no. 202, srinivasa nivas, mvp, vizag", "530017","Andhra Pradesh","India"));
//		Employee emp2= new Employee(2, "GokulKrishna", "Teppala", "gpkulkrishnat@xyz.com", "9293768692", "Male", new EmployeeDetails(1,9,"D.no 58/27, Jyoti Nagar, Visakhapatnam","530018","Andhra Pradesh","India"));
//		
//		employees.add(emp1);
//	    employees.add(emp2);
//	    Integer[] ids={1,2}; 
//	    employeeService.deleteSomeEmployees(ids);
//	    for(int id:ids)
//	    {
//	    employeeDao.deleteById(id);
//	    }
//	}
//	
//	@Test
//	public void getDBUrlTest()
//	{
//		DBDetails dbdetails= new DBDetails("jdbc:mysql://localhost:3306/EmployeeDatabase","root","root","com.mysql.cj.jdbc.Driver");
//		dbDetails.getUrl();
//	}
//	
//	@Test
//	public void getDBUsenameTest()
//	{
//		DBDetails dbdetails= new DBDetails("jdbc:mysql://localhost:3306/EmployeeDatabase","root","root","com.mysql.cj.jdbc.Driver");
//		dbDetails.getUsername();
//	}
//	
//	@Test
//	public void getDBPassword()
//	{
//		DBDetails dbdetails= new DBDetails("jdbc:mysql://localhost:3306/EmployeeDatabase","root","root","com.mysql.cj.jdbc.Driver");
//		dbDetails.getPassword();
//	}
//	
//	@Test
//	public void getDBDriverClassNameTest()
//	{
//		DBDetails dbdetails= new DBDetails("jdbc:mysql://localhost:3306/EmployeeDatabase","root","root","com.mysql.cj.jdbc.Driver");
//		dbDetails.getDriverClassName();
//	}	
//}
