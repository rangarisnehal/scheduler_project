package com.snehal.test.dtos;

import com.snehal.test.models.Employee;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PostEmployeeRequest {

    private String name;
    private String department;
    private BigDecimal salary;


    public Employee toEmployee(){
        Employee employee = new Employee();
        employee.setName(this.name);
        employee.setDepartment(this.department);
        employee.setSalary(this.salary);

        return employee;
    }

}
