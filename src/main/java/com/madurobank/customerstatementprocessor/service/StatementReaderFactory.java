package com.madurobank.customerstatementprocessor.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatementReaderFactory {

	private static final Logger logger = LoggerFactory.getLogger(StatementReaderFactory.class);

	public static StatementReaderStrategy getStatementReader(File statement) {

		String fileType = null;
		try {
			fileType = Files.probeContentType(statement.toPath());

		} catch (IOException e) {
			logger.error(e.getMessage());
			// TODO: handle exception
			e.printStackTrace();
		}

		StatementReaderStrategy statementReaderStrategy = null;

		if (fileType.equalsIgnoreCase("application/vnd.ms-excel")) {

			statementReaderStrategy = new CSVReaderStrategy();

		} else if (fileType.equalsIgnoreCase("text/xml")) {

			statementReaderStrategy = new XMLReaderStrategy();

		} else {
			logger.error("ERROR: Invalid file format for file " + statement.getName());
		}

		return statementReaderStrategy;

	}

}
