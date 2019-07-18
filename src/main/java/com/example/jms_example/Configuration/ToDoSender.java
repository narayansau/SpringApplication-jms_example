package com.example.jms_example.Configuration;

import com.example.jms_example.Entity.ToDo;
import com.example.jms_example.Producer.ToDoProducer;
//import org.springframework.beans.factory.annotation.Value;
import com.example.jms_example.Producer.ToDoProducer;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender{

    @Bean
    public CommandLineRunner sendToDos (@Value( "${todo.jms.destination}"
                     String destination, ToDoProducer producer) {
        return args -> {
            producer.sendTo(destination,new ToDo("workout tomorrow morning!"));
        };

    }
}
