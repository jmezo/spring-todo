package hu.flowacademy.todo.utils;

import hu.flowacademy.todo.persistance.model.Role;
import hu.flowacademy.todo.persistance.model.User;
import hu.flowacademy.todo.persistance.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Component
@Transactional
@AllArgsConstructor
public class InitDataLoader {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        userRepository.save(User.builder().username("john").password(passwordEncoder.encode("123")).role(Role.USER).build());
        userRepository.save(User.builder().username("bill").password(passwordEncoder.encode("123")).role(Role.ADMIN).build());
    }

}
