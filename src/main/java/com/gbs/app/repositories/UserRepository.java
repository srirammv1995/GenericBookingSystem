package com.gbs.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbs.app.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByName(String name);
	public void deleteByName(String name);
	public UserEntity findByNameAndPassword(String name,String password);
}
