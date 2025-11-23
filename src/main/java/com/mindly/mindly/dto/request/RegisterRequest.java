package com.mindly.mindly.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String nome;
    private String username;
    private String email;
    private int idade;
    private String documento;
    private String password;
}
