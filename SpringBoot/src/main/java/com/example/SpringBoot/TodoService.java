package com.example.SpringBoot;

import com.example.SpringBoot.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    public Todo createTodo(Todo todo){
        return todoRepo.save(todo);
    }

    public Todo getTodoById(Long id){
        return todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public List<Todo> getTodos(){
        return todoRepo.findAll();
    }

    public Todo updateTodo(Todo todo){
        return todoRepo.save(todo);
    }

    public void deleteTodoById(Long id){
        todoRepo.delete(getTodoById(id));
    }

    public void deleteTodo(Todo todo){
        todoRepo.delete(todo);
    }

    public Page<Todo> getAllTodosPages(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return todoRepo.findAll(pageable);
    }
}
