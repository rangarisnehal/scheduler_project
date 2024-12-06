package com.snehal.test.controllers;

import com.snehal.test.dtos.PostEmployeeRequest;
import com.snehal.test.dtos.PostEmployeeResponse;
import com.snehal.test.models.Employee;
import com.snehal.test.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public ResponseEntity<PostEmployeeResponse> saveEmployee(@RequestBody PostEmployeeRequest employee){
        Employee savedEmployee = employeeService.saveEmployee(employee.toEmployee());

        return new ResponseEntity<>(PostEmployeeResponse.fromEmployee(savedEmployee), HttpStatus.CREATED);
    }
}
