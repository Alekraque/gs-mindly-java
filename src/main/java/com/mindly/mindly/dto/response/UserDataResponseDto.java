package com.mindly.mindly.dto.response;

import com.mindly.mindly.domains.User;

public record UserDataResponseDto(
        String nome,
        String sobrenome,
        String email
) {

    public static UserDataResponseDto fromUser(User user) {

        String[] nomes = user.getNome().split(" ");

        String nome = nomes[0];
        String sobrenome = nomes.length > 1 ? nomes[1] : "";

        return new UserDataResponseDto(
                nome,
                sobrenome,
                user.getEmail()
        );
    }
}
