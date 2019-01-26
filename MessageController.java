package com.msgServ.springboot.ua_project;

import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MessageController {

    @Autowired
    private MessageService msgService;
	
	//Post mesgs up to 10 max
	@PostMapping(value="/postchat", produces = "application/json")
	@ResponseBody
    public ResponseEntity<List<MessageIdResponse>> postMsg(@RequestBody List<MessageInfo> listMsg) 
	{   
		return ResponseEntity.ok().body(msgService.insertMessage(listMsg));
	}
	
	 //Get msg by id
    @GetMapping(value="/chat/msgid/{msgId}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<MessageGetIdResponse> getMsgById(@PathVariable(value = "msgId") Long msgId) {
	   return ResponseEntity.ok().body(msgService.getChatById(msgId));
	}
		
	//Get msg by user name
	@GetMapping(value="/chat/uname/{username}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<MessageNameResponse>> getMsgByName(@PathVariable(value = "username") String userName) {
	   return ResponseEntity.ok().body(msgService.getChatByName(userName));
	}
}
