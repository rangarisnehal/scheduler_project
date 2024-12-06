package com.snehal.test.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.snehal.test.services.Exportable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@JsonDeserialize(as = Employee.class)
public class Employee implements Exportable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String name;
    private String department;
    private BigDecimal salary;


    @Override
    public String[] getExportHeaders() {
        return new String[]{"ID", "Name", "Department", "Salary"};
    }

    @Override
    public String[] tocsvRow() {
        return new String[]{
                String.valueOf(id),
                name,
                department,
                salary.toString()
        };
    }
}
