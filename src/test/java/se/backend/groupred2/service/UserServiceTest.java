package se.backend.groupred2.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.backend.groupred2.model.User;
import se.backend.groupred2.repository.UserRepository;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    User user;

    @Before
    public void setUp() {
        user = new User("testFirstName", "testLastName", "testUserName", true, 555L);
    }

    @Test
    public void createUserTest() {
        userService.createUser(user);
        user.setId(1L);

        List<User> userResult = userRepository.findByUserNumber(user.getUserNumber());
        User savedUser = userResult.get(0);

        assertEquals(user.toString(), savedUser.toString());
    }

    @Test
    public void updateTest() {
    }

    @Test
    public void deActivateTest() {
    }

    @Test
    public void getAllUserByteamIdTest() {
    }

    @After
    public void tearDown() {
        userRepository.delete(user);
    }
}