package com.msgServ.springboot.ua_project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo{
	  @Id
	  @GeneratedValue
	  @Column(name = "msgId", nullable = false)
	  @JsonProperty(access = Access.WRITE_ONLY)
	  private Long msgId;

	  @Column(name = "username", nullable = true)
      private String username;

	  @Column(name = "text", nullable = true)	 
	  private String text;
	  
	  @Column(name = "timeout", nullable = true)
	  private ZonedDateTime timeout;
	  
}
