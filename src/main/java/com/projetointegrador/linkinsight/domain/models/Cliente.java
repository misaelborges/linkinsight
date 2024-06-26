package com.projetointegrador.linkinsight.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Embedded
    private Cidade cidade;

    @NotBlank
    private String senha;

    @Enumerated(EnumType.STRING)
    private Genero genero;

}