package com.bridgelabz.springgreetingapp.dto;

import lombok.Data;

@Data
public class Greeting {
    private final long id;
    private final String message;

    public Greeting(long id, String message) {
        this.message = message;
        this.id = id;
    }
}
