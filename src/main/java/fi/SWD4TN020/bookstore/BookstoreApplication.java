package fi.SWD4TN020.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.SWD4TN020.bookstore.domain.Book;
import fi.SWD4TN020.bookstore.domain.BookRepository;
import fi.SWD4TN020.bookstore.domain.Category;
import fi.SWD4TN020.bookstore.domain.CategoryRepository;
import fi.SWD4TN020.bookstore.domain.User;
import fi.SWD4TN020.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return(args)->{
			Category category1 = new Category("Bildungs");
			crepository.save(category1);
			
			Category category2 = new Category("Satiiri");
			crepository.save(category2);
			
			Category category3 = new Category("Erootiikka");
			crepository.save(category3);
			
			Book test1 = new Book("12231320", "Idiootti", "Fjodor Dostojevski", "1869", category2);
			brepository.save(test1);
			
			Book test2 = new Book("12231321", "Vieterilintu kronikka", "Haruki Murakami", "1994", category1);
			brepository.save(test2);
//			brepository.save(new Book("12231320", "Idiootti", "Fjodor Dostojevski", "1869", category2));
//			brepository.save(new Book("12231321", "Vieterilintu kronikka", "Haruki Murakami", "1994", category1));
			
			User user1 = new User("user", "$2a$10$vc5N3hMOyGuqhdWbg1CUKOqpoFQQOmtXLAROiXtjrDn1VLeslilYC", "USER", "user@user.fi");
			User user2 = new User("admin", "$2a$10$9Z.FmUMcc6bkgW18.sMzZuXEXALzy8tt5vsmamof0JOsjUd7EKZNG", "ADMIN", "admin@admin.fi");
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
