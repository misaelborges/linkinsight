package com.projetointegrador.linkinsight.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    @NotBlank
    @Column(name = "endereco_cep")
    private String cep;

    @NotBlank
    @Column(name = "endereco_logradouro")
    private String logradouro;

    @NotBlank
    @Column(name = "endereco_numero")
    private String numero;

    @NotBlank
    @Column(name = "endereco_complemento")
    private String complemento;

    @NotBlank
    @Column(name = "endereco_bairro")
    private String bairro;

    @Embedded
    private Cidade cidade;
}
