package com.example.SpringBoot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @GetMapping("/get")
    String getTodo(){
        return ("Todo");
    }

    // Path Variable
    @GetMapping("/{id}")
    String getTodoById(@PathVariable long id){
        return ("Todo with ID" + id);
    }

    //Request param
    @GetMapping("")
    String getTodoByIdParam(@RequestParam("todoId") long id){
        return ("Todo with ID" + id);
    }

    // Request Body
    @PostMapping("/create")
    String createUser(@RequestBody String body){
        return body;
    }

    @PutMapping("/{id}")
    String updateTodoById(@PathVariable long id){
        return ("Update Todo with ID " + id);
    }

    @DeleteMapping("/{id}")
    String deleteTodoById(@PathVariable long id){
        return ("Delete Todo with ID " + id);
    }

}
