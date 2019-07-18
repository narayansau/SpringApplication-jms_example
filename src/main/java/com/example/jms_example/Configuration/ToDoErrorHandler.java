package com.example.jms_example.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class ToDoErrorHandler implements ErrorHandler{

    private static Logger logger =
            LoggerFactory.getLogger( ToDoErrorHandler.class );


    @Override
    public void handleError(Throwable throwable) {
        logger.warn( "ToDo Error " );
        logger.error( throwable.getCause().getMessage() );

    }
}
