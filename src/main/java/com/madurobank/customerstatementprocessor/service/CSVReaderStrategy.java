/**
 * 
 */
package com.madurobank.customerstatementprocessor.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.madurobank.customerstatementprocessor.dto.Record;

/**
 * @author vikaskumar
 *
 */
@Service
public class CSVReaderStrategy implements StatementReaderStrategy {

	@Override
	public List<Record> readStatement(File statement) throws IOException {

		MappingIterator<Record> personIter = new CsvMapper()
				.readerWithTypedSchemaFor(Record.class).readValues(statement);

		return personIter.readAll();

	}

}
