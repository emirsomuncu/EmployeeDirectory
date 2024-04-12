package com.example.employeeDirectory.dao;

import com.example.employeeDirectory.entities.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}


