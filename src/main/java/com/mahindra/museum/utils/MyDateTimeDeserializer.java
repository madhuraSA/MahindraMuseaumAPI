package com.mahindra.museum.utils;

import org.joda.time.DateTime;

import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;

public class MyDateTimeDeserializer extends DateTimeDeserializer {

	public MyDateTimeDeserializer() {
		super(DateTime.class, FormatConfig.DEFAULT_DATETIME_PARSER);
		// TODO Auto-generated constructor stub
	}

}
