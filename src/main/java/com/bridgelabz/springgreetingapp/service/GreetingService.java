package com.bridgelabz.springgreetingapp.service;

import com.bridgelabz.springgreetingapp.dto.GreetingDto;
import com.bridgelabz.springgreetingapp.entity.GreetingEntity;
import com.bridgelabz.springgreetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepo greetingRepo;

    public GreetingEntity addMessage(GreetingDto greetingDto) {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setMessage(greetingDto.getMessage());
        return greetingRepo.save(greetingEntity);
    }
}
