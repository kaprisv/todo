package com.task.ToDo.service;

import com.task.ToDo.entity.ToDo;
import com.task.ToDo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    // Create
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    // Read all
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    // Read by ID
    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    // Update
    public ToDo updateToDo(Long id, ToDo toDoDetails) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id: " + id));

        toDo.setTitle(toDoDetails.getTitle());
        toDo.setDescription(toDoDetails.getDescription());

        return toDoRepository.save(toDo);
    }

    // Delete
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id: " + id));
        toDoRepository.delete(toDo);
    }
}