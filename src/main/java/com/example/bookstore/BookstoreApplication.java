package com.example.bookstore;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class BookstoreApplication {
	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner Book(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save(new Category("Comics"));
			crepository.save(new Category("Novels"));
			crepository.save(new Category("Trilogies"));
			
			repository.save(new Book("Keijo Koodari", "Superkoodari", "Testi1234", 1997, 19.99, crepository.findByName("Comics").get(0)));

		};
	}
}
