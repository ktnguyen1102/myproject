package com.msgServ.springboot.ua_project;

import java.util.List;
public interface MessageRepositoryCustom {
	List<MessageInfo> findMessageByName(String username);
	List<MessageInfo> findMessageByNameAll(String username);
}
