package fi.SWD4TN020.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import fi.SWD4TN020.bookstore.domain.CategoryRepository;
import fi.SWD4TN020.bookstore.domain.User;
import fi.SWD4TN020.bookstore.domain.Category;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void createNewCategory() {
    	Category category = new Category("Maaginen Realismi");
    	repository.save(category);
    	assertThat(category.getCategoryid()).isNotNull();
    }
    
    @Test
    public void findCategory() {
    	Category category = repository.findById(1L).get();
    	
    	assertThat(category.getCategoryid()).isEqualTo(1L);
    }
    
    
    @Test
    public void deleteCategory() {
    	Category category = repository.findById(1L).get();
 
    	repository.delete(category);
    	
    		
    	assertThat(category.getCategoryid()).isNull();
    }    

}