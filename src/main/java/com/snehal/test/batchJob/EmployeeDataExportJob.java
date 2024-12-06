package com.snehal.test.batchJob;

import com.snehal.test.models.Employee;
import com.snehal.test.repositories.EmployeeRepository;
import com.snehal.test.stratergy.CsvExportStrategy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EmployeeDataExportJob extends AbstractBatchJob {
    private final EmployeeRepository employeeRepository;
    private final CsvExportStrategy csvExportStrategy;

    public EmployeeDataExportJob(EmployeeRepository repository, CsvExportStrategy exportStrategy) {
        this.employeeRepository = repository;
        this.csvExportStrategy = exportStrategy;
    }

    @Override
    public void execute() {
        logJobStart();

        List<Employee> employees = employeeRepository.findAll();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = String.format("employee_export_%s.csv", timestamp);

        csvExportStrategy.export(employees, filename);

        logJobCompletion();
    }
}
