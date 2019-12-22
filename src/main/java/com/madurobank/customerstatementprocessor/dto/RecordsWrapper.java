package com.madurobank.customerstatementprocessor.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RecordsWrapper {
	
	private Records records;

	public Records getRecords() {
		return records;
	}

	public void setRecords(Records records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}