package fi.SWD4TN020.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.SWD4TN020.bookstore.domain.Book;
import fi.SWD4TN020.bookstore.domain.BookRepository;
import fi.SWD4TN020.bookstore.domain.Category;
import fi.SWD4TN020.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return(args)->{
			Category category1 = new Category("Bildungs");
			crepository.save(category1);
			
			Category category2 = new Category("Satiiri");
			crepository.save(category2);
			
			Category category3 = new Category("Erootiikka");
			crepository.save(category3);
			
			Book test1 = new Book("12231320", "Idiootti", "Fjodor Dostojevski", "1869");
			brepository.save(test1);
			
			Book test2 = new Book("12231321", "Vieterilintu kronikka", "Haruki Murakami", "1994");
			brepository.save(test2);
		};
	}
}
