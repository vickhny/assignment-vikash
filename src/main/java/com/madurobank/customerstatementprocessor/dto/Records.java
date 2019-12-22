package com.madurobank.customerstatementprocessor.dto;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "records")
public final class Records {

	@JacksonXmlElementWrapper(localName = "record")
	private Record[] record;

    public Record[] getRecord ()
    {
        return record;
    }

    public void setRecord (Record[] record)
    {
        this.record = record;
    }

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
