package com.vinothks.todoapp.service;

import java.util.List;

import com.vinothks.todoapp.domain.TodoItem;

public interface TodoService {
	
	public List<TodoItem> getTodoList();

	public void addTodo(TodoItem todoItem);

	public void deleteTodo(Long id);
}
