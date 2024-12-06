package com.snehal.test.stratergy;

import com.snehal.test.services.Exportable;

import java.util.List;

public interface CsvExportStrategy {
    void export(List<? extends Exportable> data, String filename);
}
