package com.projetointegrador.linkinsight.api.dto;

import com.projetointegrador.linkinsight.domain.models.Endereco;
import com.projetointegrador.linkinsight.domain.models.Genero;
import com.projetointegrador.linkinsight.domain.models.VelocidadeInternet;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String email;

    @NotBlank
    private String celular;

    @NotBlank
    @CPF
    private String cpf;

    @Embedded
    private Endereco endereco;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private VelocidadeInternet velocidadeInternet = VelocidadeInternet.CEM;

    private Boolean ativo = true;
}