package com.vinothks.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinothks.todoapp.dao.TodoDao;
import com.vinothks.todoapp.domain.TodoItem;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDao todoDao;

	@Override
	public List<TodoItem> getTodoList() {
		// TODO Auto-generated method stub
		return todoDao.findAll();
	}

	@Override
	public void addTodo(TodoItem todoItem) {
		todoDao.save(todoItem);
	}

	@Override
	public void deleteTodo(Long id) {
		todoDao.deleteById(id);
		
	}

}
