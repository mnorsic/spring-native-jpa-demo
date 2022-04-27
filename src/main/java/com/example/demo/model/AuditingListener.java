package com.example.demo.model;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuditingListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditingListener.class);

	@PrePersist
	@PreUpdate
	@PreRemove
	private void beforeAnyOperation(Object object) {
		LOGGER.info("Operation performed on {}", object);
	}
}
