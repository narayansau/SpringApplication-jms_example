package com.example.jms_example.Producer;

import com.example.jms_example.Entity.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class ToDoProducer{

    private static  final Logger log =
            LoggerFactory.getLogger( ToDoProducer .class  );

    private JmsTemplate jmsTemplate;

    public ToDoProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate=jmsTemplate;
    }

    public void sendTo( String destination , ToDo toDo) {
        this.jmsTemplate.convertAndSend( destination ,toDo);
                log.info( "Producer > Message Sent"  );
    }
}
