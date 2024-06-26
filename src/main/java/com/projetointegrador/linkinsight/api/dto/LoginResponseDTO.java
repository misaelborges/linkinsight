package com.projetointegrador.linkinsight.api.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {

    private String name;
    private String token;

    public LoginResponseDTO(String nome, String token) {
        this.name = nome;
        this.token = token;
    }
}
