package com.example.employeeDirectory.service.concretes;

import com.example.employeeDirectory.core.utulitites.mappers.ModelMapperService;
import com.example.employeeDirectory.dao.EmployeeDao;
import com.example.employeeDirectory.entities.Employee;
import com.example.employeeDirectory.service.abstracts.EmployeeService;
import com.example.employeeDirectory.service.request.CreateOrUpdateEmployeeRequest;
import com.example.employeeDirectory.service.response.GetAllEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao ;
    private ModelMapperService modelMapperService ;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao , ModelMapperService modelMapperService) {
        this.employeeDao = employeeDao;
        this.modelMapperService=modelMapperService ;
    }


    @Override
    public List<GetAllEmployeeResponse> getAll() {

        List<Employee> employeeList = this.employeeDao.findAll();

        List<GetAllEmployeeResponse> getAllEmployeeResponses = employeeList.stream().map(emp->this.modelMapperService
                .forResponse().map(emp,GetAllEmployeeResponse.class)).toList();
        return getAllEmployeeResponses;
    }

    @Override
    public Optional<Employee> findById(int id) {
        return this.employeeDao.findById(id);
    }

    @Override
    public void createOrUpdate(CreateOrUpdateEmployeeRequest createOrUpdateEmployeeRequest) {

        Employee employee = this.modelMapperService.forRequest().map(createOrUpdateEmployeeRequest,Employee.class);
        this.employeeDao.save(employee);
    }

    @Override
    public void delete(int id) {
        this.employeeDao.deleteById(id);
    }
}
