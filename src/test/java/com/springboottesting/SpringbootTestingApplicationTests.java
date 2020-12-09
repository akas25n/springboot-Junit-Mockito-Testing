package com.springboottesting;

import com.springboottesting.model.User;
import com.springboottesting.repository.UserRepository;
import com.springboottesting.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTestingApplicationTests {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void getUserTest() {
        when(userRepository.findAll()).thenReturn(Stream
                .of(new User(1, "Akash", 30, "Germany"),
                        new User(2, "Batash", 50, "Bangladesh")).collect(Collectors.toList()));
        assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    public void findUserByAddress() {
        String address = "BD";

        when(userRepository.findByAddress(address)).thenReturn(Stream
                .of(new User(1, "Akash", 30, "BD")).collect(Collectors.toList()));

        assertEquals(1, userService.getUserByAddress(address).size());
    }

    @Test
    public void saveUserTest() {
        User user = new User(1, "Akash", 30, "USA");

        when(userRepository.save(user)).thenReturn(user);

        assertEquals(user, userService.addUser(user));
    }

    @Test
    public void deleteUserTest() {
        User user = new User(1, "Akash", 30, "USA");
        userService.deleteUser(user);

        verify(userRepository, times(1)).delete(user);
    }
}
