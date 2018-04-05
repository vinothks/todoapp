package com.vinothks.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vinothks.todoapp.Response;
import com.vinothks.todoapp.domain.TodoItem;
import com.vinothks.todoapp.service.TodoService;

@RestController
@RequestMapping("/")
public class TodoAppController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/home")
    public ModelAndView index() {
		return new ModelAndView("index");
    }
	
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
	
	@RequestMapping(value="/deletetodo", method = RequestMethod.DELETE)
	public Response deleteTodo(@RequestBody Long todoId) {
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
		Response res = new Response();
		try {
			res.setData(todoService.getTodoList());
			res.setSuccess(true);
		}catch(Exception e) {
			res.setSuccess(false);
			res.setMessage(e.getMessage());
		}
		return res;
	}
	
}
