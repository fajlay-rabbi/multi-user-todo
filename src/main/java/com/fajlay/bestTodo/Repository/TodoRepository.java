package com.fajlay.bestTodo.Repository;

import com.fajlay.bestTodo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
