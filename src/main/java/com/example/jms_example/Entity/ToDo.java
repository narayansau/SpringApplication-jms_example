package com.example.jms_example.Entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ToDo{
    @Id
    int id;
    String description;

    public ToDo(String description) {
        this.description=description;
    }
}
