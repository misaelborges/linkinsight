package com.projetointegrador.linkinsight.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CidadeNomeRequestDTO {

    @NotNull
    private String nome;
}
