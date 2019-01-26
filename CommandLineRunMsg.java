package com.msgServ.springboot.ua_project;



	import java.time.ZonedDateTime;
	import java.time.format.DateTimeFormatter;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.CommandLineRunner;
	import org.springframework.stereotype.Component;

	@Component 
	public class CommandLineRunMsg implements CommandLineRunner{

		@Autowired
		private MessageRepository resp;
		
		@Override
		public void run(String... args) throws Exception {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZ");
			//MessageInfo msg = new MessageInfo("kim", "test",ZonedDateTime.parse("2018-10-12 06:59:00 +1300", dateTimeFormatter));
			//resp.save(msg);
		}

	}

