package com.vinothks.todoapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vinothks.todoapp.domain.TodoItem;

public interface TodoDao extends CrudRepository<TodoItem, Long>{

	public List<TodoItem> findAll();
}
