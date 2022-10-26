package fi.SWD4TN020.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.SWD4TN020.bookstore.domain.Book;
import fi.SWD4TN020.bookstore.domain.BookRepository;
import fi.SWD4TN020.bookstore.domain.Category;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findBook() {
    	Book book = repository.findById(1L).get();
    	
    	assertThat(book.getId()).isEqualTo(1L);
    }
    
    @Test
    public void findByTitle() {
        List<Book> books = repository.findByTitle("Idiootti");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Fjodor Dostojevski");
    }
    

    @Test
    public void createNewBook() {
    	Book book = new Book("12341342", "Sivullinen", "Albert Camus", "1942", null);
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    


}