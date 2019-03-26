package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaRepositoryTest {
    @Autowired
    private BookRepository brepository;
    
    @Autowired
    private CategoryRepository crepository;
    
    @Autowired
    private UserRepository urepository;

    @Test
	public void createCategoryAndBook(){
		Category Uusi = new Category("Test");
		crepository.save(Uusi);
	
        Book book = new Book("Test", "Test", "123456", 0000, 1.23, Uusi);
        brepository.save(book);

		assertThat(book.getId()).isNotNull();
		assertThat(book.getTitle()).isEqualTo("Test");
	}
    
    @Test
	public void deleteAndFindBook(){
        Category Uusi = new Category("Test");
        crepository.save(Uusi);

        Book book = new Book("Test", "Test", "123456", 0000, 1.23, Uusi);
        brepository.save(book);
        List<Book> books = brepository.findByid((long) 0);
        brepository.delete(books.get(0));

        List<Book> booktest = brepository.findByid((long) 0);

        assertThat(booktest).hasSize(0);

    }
}
