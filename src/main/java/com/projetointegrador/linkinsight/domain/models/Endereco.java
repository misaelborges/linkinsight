package com.projetointegrador.linkinsight.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    @NotBlank
    @Column(name = "endereco_logradouro")
    private String logradouro;
}
