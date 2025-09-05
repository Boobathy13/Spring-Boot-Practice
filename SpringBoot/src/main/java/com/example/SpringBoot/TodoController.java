package com.example.SpringBoot;

import com.example.SpringBoot.models.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@Slf4j
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/get")
    String getTodo(){
        //todoService.printTodos();
        return ("Todo");
    }

    // Path Variable
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id){
        try{
            Todo getTodo = todoService.getTodoById(id);
            return new ResponseEntity<>(getTodo, HttpStatus.OK);
        } catch(RuntimeException exception){
//            log.info("Error");
//            log.warn();
//            log.error("", exception);
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getAllTodosPage(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<Page<Todo>>(todoService.getAllTodosPages(page, size), HttpStatus.OK);
    }

    //Request param
//    @GetMapping("")
//    String getTodoByIdParam(@RequestParam("todoId") long id){
//        return ("Todo with ID" + id);
//    }

    // Request Body
    @PostMapping("/create")
    ResponseEntity<Todo> create(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);

    }

    @PutMapping
    ResponseEntity<Todo> updateTodoById(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.updateTodo(todo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
        todoService.deleteTodoById(id);
    }

}
