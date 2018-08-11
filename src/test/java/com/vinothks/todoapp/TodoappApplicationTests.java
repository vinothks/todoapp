package com.vinothks.todoapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoappApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testApp() {
		System.out.println("Hello Todo App");
	}

}
