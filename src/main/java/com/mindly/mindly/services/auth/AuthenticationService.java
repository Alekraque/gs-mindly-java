package com.mindly.mindly.services.auth;

import com.mindly.mindly.domains.User;
import com.mindly.mindly.dto.request.LoginRequestDto;
import com.mindly.mindly.dto.request.RegisterRequest;
import com.mindly.mindly.dto.response.LoginResponse;
import com.mindly.mindly.enums.Role;
import com.mindly.mindly.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username já existe");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já existe");
        }

        User user = User.builder()
                .nome(request.getNome())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new LoginResponse("Usuário registrado com sucesso", user.getUsername(), token);
    }

    public LoginResponse login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();

        String token = jwtService.generateToken(user);

        return new LoginResponse("Login realizado com sucesso", user.getUsername(), token);
    }
}
