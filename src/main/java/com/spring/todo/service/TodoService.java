package com.spring.todo.service;

import java.util.List;

import com.spring.todo.model.Todo;

public interface TodoService {

	List<Todo> getAllTodo();

	void addTodo(Todo todo);

	void deleteTodo(int id);

	Todo updateTodo(int id);

	  
}
