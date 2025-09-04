package com.example.SpringBoot;

import com.example.SpringBoot.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// CRUD Operation
public interface TodoRepo extends JpaRepository<Todo, Long> {

}
