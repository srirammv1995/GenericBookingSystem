package com.gbs.app.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbs.app.session.entity.SessionEntity;

public interface SessionRepository extends JpaRepository<SessionEntity, Long> {
	public SessionEntity findByDateAndTime(Date date, String Time);
}
