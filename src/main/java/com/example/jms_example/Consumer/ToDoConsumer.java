package com.example.jms_example.Consumer;

import com.example.jms_example.Entity.ToDo;
import com.example.jms_example.Producer.ToDoProducer;
import com.example.jms_example.Repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.validation.Valid;

public class ToDoConsumer{

    private static   Logger log =
            LoggerFactory.getLogger( ToDoConsumer.class  );

    private ToDoRepository toDoRepository;

    public ToDoConsumer(ToDoRepository toDoRepository) {
        this.toDoRepository=toDoRepository;
    }

    @JmsListener( destination= "${todo.jms.destination}" ,  containerFactory= "jmsFactory")
    public void processToDo(@Valid ToDo todo) {
        log.info( "Consumer > " + todo );
        log.info( "ToDo created > " + this.toDoRepository.save(todo) );
    }
}
