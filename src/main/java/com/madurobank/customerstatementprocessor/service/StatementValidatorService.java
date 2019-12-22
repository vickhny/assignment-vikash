package com.madurobank.customerstatementprocessor.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.madurobank.customerstatementprocessor.dto.Record;

@Service
public class StatementValidatorService {

	public List<Report> validateRecord(List<Record> customerStatementRecords) {
		Set<Record> uniqueStatement = new HashSet<>();
		return customerStatementRecords.parallelStream().map(m -> {
			Report report = null;
			if(uniqueStatement.add(m)) {
				if (m.getStartBalance().add(m.getMutation()) != m.getEndBalance()) {
					report = new Report();
					report.setReference(m.getReference());
					report.setDescription("Balance invalid");
				}
			} else {
				report = new Report();
				report.setReference(m.getReference());
				report.setDescription("Duplicate record");
			}
			return report;
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}
	
}
