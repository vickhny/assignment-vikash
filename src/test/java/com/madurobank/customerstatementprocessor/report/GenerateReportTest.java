/**
 * 
 */
package com.madurobank.customerstatementprocessor.report;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.madurobank.customerstatementprocessor.service.Report;

/**
 * @author vikaskumar
 *
 */
@SpringBootTest
public class GenerateReportTest {

	@InjectMocks
	private GenerateReport generateReport = new GenerateReport();

	@Value("${reports.path}")
	private String reportPath;

	@Before	
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGenerateCreatesCSVFileWhenValidListIsPassed() {
		List<Report> invalidRecords = mockedRecords(5);
		generateReport.generate(invalidRecords);
		File file = new File(reportPath + File.separator + "invalid-records.csv");
		assertTrue(file.exists());
	}

	private List<Report> mockedRecords(int num) {
		List<Report> records = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Report record = new Report();
			record.setReference(String.valueOf(i));
			record.setDescription("Test" + i);
		}
		return records;
	}
}
