package com.example.jms_example.Repository;

import com.example.jms_example.Entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface  ToDoRepository extends CrudRepository<ToDo, String> {
}
