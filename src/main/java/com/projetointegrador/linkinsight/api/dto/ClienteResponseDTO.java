package com.projetointegrador.linkinsight.api.dto;

import com.projetointegrador.linkinsight.domain.models.Cidade;
import com.projetointegrador.linkinsight.domain.models.Endereco;
import com.projetointegrador.linkinsight.domain.models.Genero;
import lombok.Data;

@Data
public class ClienteResponseDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String celular;
    private String cpf;
    private Endereco endereco;
    private Cidade cidade;
    private String senha;
    private Genero genero;
}
