package hu.flowacademy.todo.service;

import hu.flowacademy.todo.persistance.model.User;
import hu.flowacademy.todo.persistance.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {

    @Mock
    BCryptPasswordEncoder passwordEncoder;

    @BeforeAll
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save(@Mock UserRepository userRepository) {
        User user = User.builder().username("asd").password("bsd").build();
        new UserService(userRepository, passwordEncoder).save(user);
        assertNotEquals("bsd", user.getPassword());
    }

    @Test
    public void update(@Mock UserRepository userRepository) {
        User user = User.builder().id(2L).username("asd").password("bsd").build();
        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        new UserService(userRepository, null).save(user);
        assertEquals("bsd", user.getPassword());
    }
}