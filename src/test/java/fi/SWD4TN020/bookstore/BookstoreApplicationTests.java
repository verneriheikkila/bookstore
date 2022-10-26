package fi.SWD4TN020.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import fi.SWD4TN020.bookstore.webcontroller.BookListController;
import fi.SWD4TN020.bookstore.webcontroller.CategoryListController;
import fi.SWD4TN020.bookstore.webcontroller.IndexController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookListController bookListController;
	@Autowired
	private CategoryListController categoryListController;
	@Autowired
	private IndexController indexController;
	
	
	@Test
	public void contextLoads() {
		assertThat(bookListController).isNotNull();
		assertThat(categoryListController).isNotNull();
		assertThat(indexController).isNotNull();
	}

}
