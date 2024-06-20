package com.projetointegrador.linkinsight.api.dto;

import com.projetointegrador.linkinsight.domain.models.Endereco;
import com.projetointegrador.linkinsight.domain.models.Genero;
import com.projetointegrador.linkinsight.domain.models.VelocidadeInternet;
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
    private String senha;
    private Genero genero;
    private VelocidadeInternet velocidadeInternet;
    private Boolean ativo;
}
