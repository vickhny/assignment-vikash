/**
 * 
 */
package com.madurobank.customerstatementprocessor.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author vikaskumar
 *
 */
public class AccountNumber {

	@JacksonXmlProperty(localName = "")
	private String value;

	public AccountNumber(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
