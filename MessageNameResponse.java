package com.msgServ.springboot.ua_project;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString

public class MessageNameResponse {
  private Long id;
  private String text;

}
