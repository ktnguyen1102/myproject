package com.msgServ.springboot.ua_project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageInfo, Long>{
	
}
