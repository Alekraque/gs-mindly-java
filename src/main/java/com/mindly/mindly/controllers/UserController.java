package com.mindly.mindly.controllers;

import com.mindly.mindly.domains.User;
import com.mindly.mindly.dto.request.UserDataRequestDto;
import com.mindly.mindly.dto.response.UserDataResponseDto;
import com.mindly.mindly.services.userService.UserDataServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDataServiceInterface createUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDataResponseDto createUser(@RequestBody @Valid UserDataRequestDto userDto) {
        User createdUser = createUserService.execute(userDto.toUser());
        return UserDataResponseDto.fromUser(createdUser);
    }
}
