package com.task.ToDo.controller;

import com.task.ToDo.entity.ToDo;
import com.task.ToDo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    // CREATE - POST /api/todos
    @PostMapping
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        ToDo createdToDo = toDoService.createToDo(toDo);
        return new ResponseEntity<>(createdToDo, HttpStatus.CREATED);
    }

    // READ ALL - GET /api/todos
    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = toDoService.getAllToDos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // READ ONE - GET /api/todos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return toDoService.getToDoById(id)
                .map(toDo -> new ResponseEntity<>(toDo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE - PUT /api/todos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDo toDoDetails) {
        try {
            ToDo updatedToDo = toDoService.updateToDo(id, toDoDetails);
            return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - DELETE /api/todos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        try {
            toDoService.deleteToDo(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}