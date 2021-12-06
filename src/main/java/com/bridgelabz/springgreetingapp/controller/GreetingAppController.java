package com.bridgelabz.springgreetingapp.controller;

/**
 * Purpose To Simulate with Greeting App
 *
 * @author Sonali G
 * @version 2.6.0
 * @since 06-12-2021
 */
import com.bridgelabz.springgreetingapp.dto.Greeting;
import com.bridgelabz.springgreetingapp.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingAppController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = {"", "/"})
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    //http://localhost:8080/greeting/?firstName=Sonali&lastName=Gadge
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if (user.getFirstName() == null && user.getLastName() == null) {
            home();
        }
        return new Greeting(counter.incrementAndGet(), String.format(template, user));
    }
}
