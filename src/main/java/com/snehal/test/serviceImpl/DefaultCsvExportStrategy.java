package com.snehal.test.serviceImpl;

import com.opencsv.CSVWriter;
import com.snehal.test.exception.DataExportException;
import com.snehal.test.services.Exportable;
import com.snehal.test.stratergy.CsvExportStrategy;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class DefaultCsvExportStrategy implements CsvExportStrategy {

    @Override
    public void export(List<? extends Exportable> data, String filename) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {

            writer.writeNext(data.get(0).getExportHeaders());

            for (Exportable item : data) {
                writer.writeNext(item.tocsvRow());
            }
        } catch (IOException e) {
            throw new DataExportException("Failed to export data", e);
        }
    }
}
