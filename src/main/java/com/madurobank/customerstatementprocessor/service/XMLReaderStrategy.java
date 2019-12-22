/**
 * 
 */
package com.madurobank.customerstatementprocessor.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.madurobank.customerstatementprocessor.dto.Record;
import com.madurobank.customerstatementprocessor.dto.Records;
import com.madurobank.customerstatementprocessor.dto.RecordsWrapper;

/**
 * @author vikaskumar
 *
 */
@Service
public class XMLReaderStrategy implements StatementReaderStrategy {

	@Override
	public List<Record> readStatement(File statement) {

		ObjectMapper objectMapper = new XmlMapper();
		// Reads from XML and converts to POJO

		Records records = null;

		try {
			records = objectMapper.readValue(StringUtils
					.toEncodedString(Files.readAllBytes(Paths.get(statement.getName())), StandardCharsets.UTF_8),
					Records.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Arrays.asList(records.getRecord());

	}

}
