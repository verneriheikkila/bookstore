package fi.SWD4TN020.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.SWD4TN020.bookstore.domain.Book;
import fi.SWD4TN020.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return(args)->{
			Book test1 = new Book("12231320", "Idiootti", "Fjodr Dostojevski", "1869");
			Book test2 = new Book("12231321", "Vieterilintu kronikka", "Haruki Murakami", "1994");
			
			repository.save(test1);
			repository.save(test2);
		};
	}
}
