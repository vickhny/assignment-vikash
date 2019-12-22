package com.madurobank.customerstatementprocessor.dto;

import java.math.BigDecimal;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Record {

	private String reference;

	private String accountNumber;

	private String description;

	private BigDecimal startBalance;

	private BigDecimal mutation;

	private BigDecimal endBalance;

	public Record() {
	}

	public Record(@JacksonXmlProperty(localName = "reference", isAttribute = true) String reference,
			@JacksonXmlProperty(localName = "accountNumber") String accountNumber,
			@JacksonXmlProperty(localName = "description") String description,
			@JacksonXmlProperty(localName = "startBalance") BigDecimal startBalance,
			@JacksonXmlProperty(localName = "mutation") BigDecimal mutation,
			@JacksonXmlProperty(localName = "endBalance") BigDecimal endBalance) {
		this.reference = reference;
		this.accountNumber = accountNumber;
		this.description = description;
		this.startBalance = startBalance;
		this.mutation = mutation;
		this.endBalance = endBalance;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getStartBalance() {
		return startBalance;
	}

	public void setStartBalance(BigDecimal startBalance) {
		this.startBalance = startBalance;
	}

	public BigDecimal getMutation() {
		return mutation;
	}

	public void setMutation(BigDecimal mutation) {
		this.mutation = mutation;
	}

	public BigDecimal getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(BigDecimal endBalance) {
		this.endBalance = endBalance;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Objects.equals(reference, other.reference);
	}

}
