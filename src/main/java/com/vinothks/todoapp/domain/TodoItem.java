package com.vinothks.todoapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_todolist")
public class TodoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long todoItemId;
	
	private String todoDesc;
	
	private String todoStatus;

	public Long getTodoItemId() {
		return todoItemId;
	}

	public void setTodoItemId(Long todoItemId) {
		this.todoItemId = todoItemId;
	}

	public String getTodoDesc() {
		return todoDesc;
	}

	public void setTodoDesc(String todoDesc) {
		this.todoDesc = todoDesc;
	}

	public String getTodoStatus() {
		return todoStatus;
	}

	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}
	
}
