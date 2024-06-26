package com.projetointegrador.linkinsight.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    @NotBlank
    private String logradouro;
}
