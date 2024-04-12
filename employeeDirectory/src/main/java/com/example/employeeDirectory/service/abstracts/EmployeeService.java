package com.example.employeeDirectory.service.abstracts;

import com.example.employeeDirectory.entities.Employee;
import com.example.employeeDirectory.service.request.CreateOrUpdateEmployeeRequest;
import com.example.employeeDirectory.service.response.GetAllEmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<GetAllEmployeeResponse> getAll();

    public Optional<Employee> findById(int id);

    public void createOrUpdate(CreateOrUpdateEmployeeRequest createOrUpdateEmployeeRequest);

    public void delete(int id) ;


}
