package com.projetointegrador.linkinsight.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Cidade {

    @NotBlank
    @Column(name = "endereco_cidade_nome")
    private String nome;

}
