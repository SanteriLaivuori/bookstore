package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.web.BookController;
import com.example.bookstore.web.UserController;

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class SmokeTesting {
		@Autowired
		private BookController bookcontroller;

		@Autowired
		private UserController usercontroller;

		@Test
		public void contextLoads() throws Exception {
			assertThat(bookcontroller).isNotNull();
			assertThat(usercontroller).isNotNull();
		}
	}
