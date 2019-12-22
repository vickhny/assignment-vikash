package com.madurobank.customerstatementprocessor.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.madurobank.customerstatementprocessor.service.Report;

@Service
public class GenerateReport {

	@Value("${reports.path}")
	private String reportFile;

	public void generate(List<Report> invalidReports) {
		CsvMapper csvMapper = new CsvMapper();
		CsvSchema csvSchema = csvMapper.schemaFor(Report.class).withHeader();
		try {
			File file = ResourceUtils.getFile("classpath:" + reportFile);
			Files.write(file.toPath(),
					csvMapper.writer(csvSchema).writeValueAsString(invalidReports).getBytes(),
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
