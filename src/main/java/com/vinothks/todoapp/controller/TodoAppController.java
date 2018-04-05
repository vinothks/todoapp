package com.vinothks.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vinothks.todoapp.Response;
import com.vinothks.todoapp.domain.TodoItem;
import com.vinothks.todoapp.service.TodoService;

@RequestMapping("/todo")
@RestController
public class TodoAppController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="/addtodo", method = RequestMethod.POST)
	public Response addTodo(@RequestBody TodoItem todoItem) {
		Response res = new Response();
		try {
			todoService.addTodo(todoItem);
			res.setSuccess(true);
		}catch(Exception e) {
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/updatetodo", method = RequestMethod.POST)
	public Response updateTodo(@RequestBody TodoItem todoItem) {
		Response res = new Response();
		
		if(todoItem.isTodoCompleted()) {
			todoItem.setTodoCompleted(false);
		}else {
			todoItem.setTodoCompleted(true);
		}
		
		try {
			todoService.addTodo(todoItem);
			res.setSuccess(true);
		}catch(Exception e) {
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/deletetodo", method = RequestMethod.DELETE)
	public Response deleteTodo(@RequestBody Long todoId) {
		System.out.println(todoId);
		Response res = new Response();
		try {
			todoService.deleteTodo(todoId);
			res.setSuccess(true);
		}catch(Exception e) {
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}
	
	@RequestMapping(value="/gettodolist", method = RequestMethod.GET)
	public Response getTodoList() {
		System.out.println("ok Entered");
		Response res = new Response();
		try {
			List<TodoItem> list = todoService.getTodoList();					
			res.setCustomData(list);
			res.setSuccess(true);
			System.out.println(res.getCustomData().toString());
		}catch(Exception e) {
			e.printStackTrace();
			res.setSuccess(false);
			res.setMessage(e.getMessage());
			System.out.println("Error");
		}
		return res;
	}
	
}
