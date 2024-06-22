package com.projetointegrador.linkinsight.api.dto;

import com.projetointegrador.linkinsight.domain.models.Cidade;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EnderecoRequestDTO {

    @NotBlank
    private String logradouro;

    @NotNull
    private CidadeNomeRequestDTO cidade;
}
