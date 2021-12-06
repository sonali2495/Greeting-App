package com.bridgelabz.springgreetingapp.dto;

import lombok.Data;

@Data
public class UserDto {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

