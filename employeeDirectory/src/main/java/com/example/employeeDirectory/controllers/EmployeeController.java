package com.example.employeeDirectory.controllers;

import com.example.employeeDirectory.entities.Employee;
import com.example.employeeDirectory.service.abstracts.EmployeeService;
import com.example.employeeDirectory.service.request.CreateOrUpdateEmployeeRequest;
import com.example.employeeDirectory.service.response.GetAllEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService ;

    @Autowired
    public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService ;
    }


    // for "/list"
    @GetMapping("/list")
    public String listEmployee(Model model) {
        List<GetAllEmployeeResponse> theEmployees  = this.employeeService.getAll();
        model.addAttribute("employees" , theEmployees);
        return "employees/list-employees";
    }

    @GetMapping ("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        //formda girilen değerleri altta tanımlanan employeede tutmayı sağlamak için yapıldı
        //girilen değerleri newlenen employeede tutup formu iletirken model attributea bu employee geçiliyor
        //bu bir thymeleaf özelliğidir
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") CreateOrUpdateEmployeeRequest createOrUpdateEmployeeRequest) {
        this.employeeService.createOrUpdate(createOrUpdateEmployeeRequest);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id , Model thModel) {
        Employee theEmployee  = employeeService.findById(id).get();
        thModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id ) {
        employeeService.delete(id);
        return "redirect:/employees/list";
    }
}
