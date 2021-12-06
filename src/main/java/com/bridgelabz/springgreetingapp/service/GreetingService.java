package com.bridgelabz.springgreetingapp.service;

import com.bridgelabz.springgreetingapp.dto.GreetingDto;
import com.bridgelabz.springgreetingapp.entity.GreetingEntity;
import com.bridgelabz.springgreetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private static final String MESSAGE_SAVED = "Message Saved...";

    @Autowired
    private GreetingRepo greetingRepo;

    public String addMessage(GreetingDto greetingDto) {
        GreetingEntity greetingEntity = new GreetingEntity();
        greetingEntity.setMessage(greetingDto.getMessage());
        greetingRepo.save(greetingEntity);
        return MESSAGE_SAVED;
    }

    public Object findMessageById(int id) {
        Optional<GreetingEntity> find = greetingRepo.findById(id);
        if (find.isPresent())
            return greetingRepo.findById(id);
        else
            return "Given id is Not Found";
    }

    public Object getAllMessages() {
        List<GreetingEntity> allMessages = greetingRepo.findAll();
        if (allMessages.isEmpty()) {
            return "Message Box is Empty";
        }
        return greetingRepo.findAll();
    }

    public Object updateMessage(int id, GreetingDto greetingDto) {
        Optional<GreetingEntity> idCheck = greetingRepo.findById(id);
        if (idCheck.isPresent()) {
            GreetingEntity greetingEntity = this.greetingRepo.findById(id).get();
            greetingEntity.setMessage(greetingDto.getMessage());
            this.greetingRepo.save(greetingEntity);
            return "Message Updated Successfully" + "\n" + greetingEntity;
        } else
            return "Record Not Found!";
    }

    public Object deleteMessage(int id) {
        Optional<GreetingEntity> idCheck = greetingRepo.findById(id);
        if (idCheck.isPresent()) {
            GreetingEntity greetingEntity = greetingRepo.findById(id).get();
            greetingRepo.delete(greetingEntity);
            return "Message Deleted Successfully";
        } else
            return "Record Not Found!";
    }

}
