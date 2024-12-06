package com.snehal.test.scheduler;

import com.snehal.test.batchJob.EmployeeDataExportJob;
import com.snehal.test.batchJob.ExchangeRateUpdaterJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class BatchJobScheduler {
    private final EmployeeDataExportJob employeeExportJob;
    private final ExchangeRateUpdaterJob exchangeRateJob;

    @Autowired
    public BatchJobScheduler(
            EmployeeDataExportJob employeeExportJob,
            ExchangeRateUpdaterJob exchangeRateJob
    ) {
        this.employeeExportJob = employeeExportJob;
        this.exchangeRateJob = exchangeRateJob;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void runEmployeeExportJob() {
        employeeExportJob.execute();
    }

    @Scheduled(cron = "0 0 */6 * * ?")
    public void runExchangeRateUpdateJob() {
        exchangeRateJob.execute();
    }
}
