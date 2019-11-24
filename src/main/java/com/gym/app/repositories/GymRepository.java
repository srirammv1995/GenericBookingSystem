package com.gym.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.app.gym.Gym;
import com.gym.app.gym.entity.GymEntity;

public interface GymRepository extends JpaRepository<GymEntity, Long>{

}
