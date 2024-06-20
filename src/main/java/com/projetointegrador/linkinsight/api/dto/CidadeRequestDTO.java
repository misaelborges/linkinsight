package com.projetointegrador.linkinsight.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CidadeRequestDTO {

    @NotBlank
    private String nome;
}
