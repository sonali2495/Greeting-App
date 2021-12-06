package com.bridgelabz.springgreetingapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "greetinApp")
@Data
public class GreetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String message;
}
