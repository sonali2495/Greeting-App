package com.bridgelabz.springgreetingapp.repository;

import com.bridgelabz.springgreetingapp.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepo extends JpaRepository<GreetingEntity, Integer> {
}
