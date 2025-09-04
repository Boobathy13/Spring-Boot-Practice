package com.example.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    public void printTodos(){
        System.out.println(todoRepo.getAllTodos());
    }
}
