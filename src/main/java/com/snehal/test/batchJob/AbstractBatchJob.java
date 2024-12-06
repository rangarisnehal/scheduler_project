package com.snehal.test.batchJob;

import com.snehal.test.services.BatchJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


public abstract class AbstractBatchJob implements BatchJob {
    private static final Logger logger = LoggerFactory.getLogger(AbstractBatchJob.class);

    protected void logJobStart() {
        logger.info("{} job started at {}", getClass().getSimpleName(), LocalDateTime.now());
    }

    protected void logJobCompletion() {
        logger.info("{} job completed successfully", getClass().getSimpleName());
    }
}
