package com.mindly.mindly.services.userService;

import com.mindly.mindly.domains.User;
import com.mindly.mindly.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements UserDataServiceInterface{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User execute(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }
        User userToSave = User.builder()
                .nome(user.getNome())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .build();

        System.out.println(userToSave);

        User savedUser = userRepository.save(userToSave);

        return savedUser;
    }
}
