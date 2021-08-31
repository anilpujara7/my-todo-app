package com.spring.todo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.todo.model.Todo;
import com.spring.todo.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/")
	public String getAllTodoData(Model model) {
		model.addAttribute("todo", todoService.getAllTodo());

		return "todo";

	}

	@GetMapping("/addTodo")
	public String addTodo(Model model) {

		model.addAttribute("todo", new Todo());
		return "todoAdd";

	}

	@PostMapping("/save")
	public String saveTodo( @ModelAttribute Todo todo) {
		 
		todoService.addTodo(todo);
		return "redirect:/";

	}

	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {
		todoService.deleteTodo(id);
		return "redirect:/";

	}

	@GetMapping("/update/{id}")
	public String updateById(@PathVariable int id, Model model) {

		Todo updateTodo = todoService.updateTodo(id);
		model.addAttribute("todo", updateTodo);

		return "todoUpdate";

	}

}
