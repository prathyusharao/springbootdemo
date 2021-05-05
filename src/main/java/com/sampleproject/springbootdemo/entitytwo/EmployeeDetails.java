package com.sampleproject.springbootdemo.entitytwo;
 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.sampleproject.springbootdemo.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name= "Employee_Details")
@AttributeOverride(name= "id", column= @Column(name= "ID", nullable = false))

 

public class EmployeeDetails {

 


    @Id
    @Column(name= "id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name ="Employee_age")
    private int Employee_age;
    @Column(name ="Employee_address")
    private String Employee_address;
    @Column(name ="Employee_pincode")
    private String Employee_pincode;
    @Column(name ="Employee_state")
    private String Employee_state;
    @Column(name ="Employee_country")
    private String Employee_country;

 

    @OneToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinColumn (name= "EMPLOYEE_ID",nullable=false)
    @JsonBackReference("employee_sn")
    private Employee employee;
    
    public EmployeeDetails(int id, int employee_age, String employee_address, String employee_pincode,
            String employee_state, String employee_country) {
        super();
        this.id = id;
        Employee_age = employee_age;
        Employee_address = employee_address;
        Employee_pincode = employee_pincode;
        Employee_state = employee_state;
        Employee_country = employee_country;
    }
    
}