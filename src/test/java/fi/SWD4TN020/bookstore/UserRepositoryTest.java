package fi.SWD4TN020.bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import fi.SWD4TN020.bookstore.domain.UserRepository;
import fi.SWD4TN020.bookstore.domain.User;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void createNewUser() {
    	User user = new User("kvh", "qwerty123", "USER", "kvh@user.fi");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }
    
    @Test
    public void findUser() {
    	User user = repository.findById(1L).get();
    	
    	assertThat(user.getId()).isEqualTo(1L);
    }
    
 

}