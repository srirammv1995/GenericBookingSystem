package com.gym.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.app.gym.Gym;

public interface GymRepository extends JpaRepository<Gym, Long>{

}
