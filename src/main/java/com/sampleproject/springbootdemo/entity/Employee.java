package com.sampleproject.springbootdemo.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sampleproject.springbootdemo.entitytwo.EmployeeDetails;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import lombok.Getter;
//import lombok.Setter;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;


//@Getter
//@Setter
@Entity
@Table(name= "Employee")
public class Employee {
	
	public String getEmployee_fname() {
		return Employee_fname;
	}

	public void setEmployee_fname(String employee_fname) {
		Employee_fname = employee_fname;
	}

	public String getEmployee_lname() {
		return Employee_lname;
	}

	public void setEmployee_lname(String employee_lname) {
		Employee_lname = employee_lname;
	}

	public String getEmployee_email() {
		return Employee_email;
	}

	public void setEmployee_email(String employee_email) {
		Employee_email = employee_email;
	}

	public String getEmployee_phoneno() {
		return Employee_phoneno;
	}

	public void setEmployee_phoneno(String employee_phoneno) {
		Employee_phoneno = employee_phoneno;
	}

	public String getEmployee_gender() {
		return Employee_gender;
	}

	public void setEmployee_gender(String employee_gender) {
		Employee_gender = employee_gender;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public EmployeeDetails getEmployeedetails() {
		return employeedetails;
	}

	public void setEmployeedetails(EmployeeDetails employeedetails) {
		this.employeedetails = employeedetails;
	}

	@Column(name= "Employee_fname")
    private String Employee_fname;	
	@Column(name= "Employee_lname")
    private String Employee_lname;	
	@Column(name = "Employee_email")
	private String Employee_email;
	@Column(name= "Employee_phoneno")
    private String Employee_phoneno;
	@Column(name ="Employee_gender")
	private String Employee_gender;
	@Id
	@Column(name= "Employee_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employee_Id;
	
	
	@OneToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="employee",orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonManagedReference("employee_sn")
	private EmployeeDetails employeedetails;
	
	
	public Employee(int employee_Id, String employee_lname, String employee_email, String employee_phoneno,
			String employee_gender, String employee_fname, EmployeeDetails employeedetails) {
		super();
		Employee_fname = employee_fname;
		Employee_lname = employee_lname;
		Employee_email = employee_email;
		Employee_phoneno = employee_phoneno;
		Employee_gender = employee_gender;
		Employee_Id = employee_Id;
		this.employeedetails = employeedetails;
	}

	public Employee()
	{
		
	}

}
