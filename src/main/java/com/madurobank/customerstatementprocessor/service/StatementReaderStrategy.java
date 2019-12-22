package com.madurobank.customerstatementprocessor.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.madurobank.customerstatementprocessor.dto.Record;

public interface StatementReaderStrategy {
	
	public List<Record> readStatement(File statement) throws IOException;

}
