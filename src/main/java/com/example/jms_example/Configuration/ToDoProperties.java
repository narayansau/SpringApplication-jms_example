package com.example.jms_example.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;




    @Data
   // @ConfigurationProperties(prefix = "todo.jms")
    public class ToDoProperties{
        private String destination;

}
