package com.snehal.test.dtos;

import com.snehal.test.models.Employee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PostEmployeeResponse {

    private Long id;
    private String name;
    private String department;
    private BigDecimal salary;

    public static PostEmployeeResponse fromEmployee(Employee employee){
        PostEmployeeResponse response = new PostEmployeeResponse();
        response.setId(employee.getId());
        response.setName(employee.getName());
        response.setDepartment(employee.getDepartment());
        response.setSalary(employee.getSalary());
        return response;
    }

}
