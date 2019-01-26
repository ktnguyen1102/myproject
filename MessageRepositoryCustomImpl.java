package com.msgServ.springboot.ua_project;

import java.util.List;

import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional(readOnly = true)
public class MessageRepositoryCustomImpl implements MessageRepositoryCustom {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<MessageInfo> findMessageByName(String username) {
		 Query query = entityManager.createNativeQuery("SELECT mg.* FROM message_info as mg " +
	                "WHERE mg.username LIKE ?", MessageInfo.class);
	        query.setParameter(1, username + "%");
	        return query.getResultList();
	}
	
	@Override
	public List<MessageInfo> findMessageByNameAll(String username) {
		 Query query = entityManager.createNativeQuery("SELECT * from (SELECT ex.* from message_expire ex where ex.timeout > systimestamp + 1 and ex.username LIKE ? UNION ALL SELECT mg.* FROM message_info as mg " +
	                "WHERE mg.username LIKE ? ) order by msg_id", MessageInfo.class);
		 query.setParameter(1, username + "%");
		 query.setParameter(2, username + "%");
	        return query.getResultList();
	}
	
}