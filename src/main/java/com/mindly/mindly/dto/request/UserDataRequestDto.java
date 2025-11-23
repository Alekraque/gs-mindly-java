package com.mindly.mindly.dto.request;

import com.mindly.mindly.domains.User;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDataRequestDto {

    @NotBlank
    private String nomeCompleto;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @Min(16)
    @Max(120)
    private int idade;

    private String documento;

    public User toUser() {

        String[] nomes = nomeCompleto.split(" ");

        String nome = nomes[0];

        return User.builder()
                .nome(nome)
                .email(email)
                .password(password)
                .documento(documento)
                .idade(idade)
                .build();
    }
}
