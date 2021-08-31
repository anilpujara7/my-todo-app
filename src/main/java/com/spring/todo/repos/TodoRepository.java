package com.spring.todo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
