package com.msgServ.springboot.ua_project;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateUtil {
	public ZonedDateTime parseToZonedDateTime(String date, String dateFormat) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
	    LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
	    ZoneOffset defaultOffset =  ZoneId.systemDefault().getRules().getOffset(localDateTime);
	    DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
	            .append(formatter)
	            .parseDefaulting(ChronoField.OFFSET_SECONDS, defaultOffset.getTotalSeconds())
	            .toFormatter();
	    return ZonedDateTime.parse(date, dateTimeFormatter);
	  }

}
