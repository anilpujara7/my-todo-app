package com.spring.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.todo.model.Todo;
import com.spring.todo.repos.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	@Autowired
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodo() {
		return todoRepository.findAll();
	}

	@Override
	public void addTodo(Todo todo) {

		todoRepository.save(todo);

	}

	@Override
	public void deleteTodo(int id) {
		todoRepository.deleteById(id);

	}

	@Override
	public Todo updateTodo(int id) {

		Optional<Todo> optional = todoRepository.findById(id);
		Todo todo = null;
		if (optional.isPresent()) {
			todo = optional.get();
		}

		return todo;

	}

	 

}
