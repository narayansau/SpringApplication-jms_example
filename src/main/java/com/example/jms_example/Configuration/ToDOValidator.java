package com.example.jms_example.Configuration;

import com.example.jms_example.Entity.ToDo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ToDOValidator implements Validator{
    @Override
    public boolean supports(Class <?> aClass) {
        return aClass.isAssignableFrom( ToDo.class );
    }

    @Override
    public void validate(Object target, Errors errors) {
        ToDo toDo = (ToDo) target;
        if (toDo == null)
            errors.reject( null, "ToDo cannot be null" );
        else
        {
            if ( toDo.getDescription() == null ||
                 toDo.getDescription().isEmpty())
                errors.rejectValue( "description",
                        null  ,
                        " Description cannot be null or empty");
        }

    }
}
