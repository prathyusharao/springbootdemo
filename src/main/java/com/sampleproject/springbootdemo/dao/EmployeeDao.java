package com.sampleproject.springbootdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sampleproject.springbootdemo.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Query("FROM Employee")
	List<Employee> findAllEmployeeByNameAsc(Sort sort);
	
}
