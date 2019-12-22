package com.madurobank.customerstatementprocessor.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.madurobank.customerstatementprocessor.dto.Record;
import com.madurobank.customerstatementprocessor.report.GenerateReport;

@Service
public class StatementProcessService {

	private static final Logger logger = LoggerFactory.getLogger(StatementProcessService.class);
	
	@Autowired
	private StatementValidatorService statementValidatorService;
		
	@Autowired
	private GenerateReport generateReport;
	
	public void processStatement(File recievedFile) throws IOException {
		
		StatementReaderStrategy statementReaderStrategy = StatementReaderFactory.getStatementReader(recievedFile);
		List<Record> customerStatementRecords = statementReaderStrategy.readStatement(recievedFile);
		generateReport.generate(statementValidatorService.validateRecord(customerStatementRecords));
		

	}

}
