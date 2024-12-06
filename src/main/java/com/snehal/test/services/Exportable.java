package com.snehal.test.services;

public interface Exportable {
    String[] getExportHeaders();
    String[] tocsvRow();
}
