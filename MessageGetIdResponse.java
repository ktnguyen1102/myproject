package com.msgServ.springboot.ua_project;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MessageGetIdResponse {
	private String username;
	private String text;
	private ZonedDateTime expire_date;
}
