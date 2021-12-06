package com.bridgelabz.springgreetingapp.controller;

/**
 * Purpose To Simulate with Greeting App
 *
 * @author Sonali G
 * @version 2.6.0
 * @since 06-12-2021
 */
import com.bridgelabz.springgreetingapp.dto.GreetingDto;
import com.bridgelabz.springgreetingapp.dto.UserDto;
import com.bridgelabz.springgreetingapp.entity.GreetingEntity;
import com.bridgelabz.springgreetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingAppController {
    private static final String template = "Hello %s!";

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(value = {"", "/"})
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    //http://localhost:8080/greeting/?firstName=Sonali&lastName=Gadge
    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {

        if (firstName == null && lastName == null) {
            home();
        }
        return String.format(template, firstName + " " + lastName);
    }

    //http://localhost:8080/add-greeting
    @PostMapping("/add-greeting")
    public String addGreeting(@RequestBody UserDto user) {
        String message = String.format(template, user.getFirstName() + " " + user.getLastName());
        GreetingDto greetingDto = new GreetingDto();
        greetingDto.setMessage(message);
        return greetingService.addMessage(greetingDto);
    }

    //http://localhost:8080/findBy/1
    @GetMapping("/findBy/{id}")
    public Object findGreeting(@PathVariable(value = "id") int id) {
        return greetingService.findMessageById(id);
    }
}
