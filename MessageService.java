package com.msgServ.springboot.ua_project;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private MessageRepositoryCustom messageRepositoryCustom;
	
	private int maxMsg = 10;
	private Long errorMaxMsg = -100L;
	
	public List<MessageIdResponse> insertMessage(List<MessageInfo> listMsg) {
		
		List<MessageIdResponse> listResponse = new ArrayList<MessageIdResponse> ();
		if (listMsg.size() > maxMsg) {
			MessageIdResponse idResponse = new MessageIdResponse();
			idResponse.setId(errorMaxMsg);
		}else {
		   for (MessageInfo info: listMsg) {
		      MessageIdResponse idResponse = new MessageIdResponse();
		      MessageInfo msgTemp = mapToMessage(info);
		      idResponse.setId(this.messageRepository.save(msgTemp).getMsgId());	  
		      listResponse.add(idResponse);
		  }
		}
		return listResponse;
	}
  //Find by Id
  	public MessageGetIdResponse getChatById(long id) {	
  		MessageGetIdResponse response = new MessageGetIdResponse();
  		Optional<MessageInfo> messageInfo = messageRepository.findById(id);
  		MessageInfo msgInfo = messageInfo.orElse(null);
  		if (messageInfo.isPresent()) {
  		   response.setUsername(msgInfo.getUsername());
  		   response.setText(msgInfo.getText());
  		   response.setExpire_date(msgInfo.getTimeout());
  		}
  		
  		return response;
  	}
  	
  //Find by Name
  	public List<MessageNameResponse> getChatByName(String name) {
  		
  		 List<MessageInfo> msgList  = messageRepositoryCustom.findMessageByNameAll(name);
  		 List<MessageNameResponse> response = new ArrayList<MessageNameResponse>();
  		 for (MessageInfo info: msgList) {
  			 MessageNameResponse msg = new MessageNameResponse();
  			 msg.setId(info.getMsgId());
  			 msg.setText(info.getText());
  			response.add(msg);
  		 }
  		 
  		 return response;
  	}

  	private MessageInfo mapToMessage (MessageInfo msgInfo) {
  		MessageInfo msgTemp = new MessageInfo();
		msgTemp.setText(msgInfo.getText());
		msgTemp.setUsername(msgInfo.getUsername());
		Instant instant = Instant.now();
		ZonedDateTime zdt = instant.atZone(ZoneOffset.UTC);
		msgTemp.setTimeout(zdt);
		return msgTemp;
  	}
}
