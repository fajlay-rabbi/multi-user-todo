package com.fajlay.bestTodo.Repository;

import com.fajlay.bestTodo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
