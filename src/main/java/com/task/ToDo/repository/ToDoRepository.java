package com.task.ToDo.repository;

import com.task.ToDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // JpaRepository provides all CRUD methods automatically
    // No need to write any methods manually
}
