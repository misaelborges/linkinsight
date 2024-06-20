package com.projetointegrador.linkinsight.api.assembler;

import com.projetointegrador.linkinsight.api.dto.ClienteResponseDTO;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ClienteResponseDTO toModel(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    public List<ClienteResponseDTO> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream().map(this::toModel).collect(Collectors.toList());
    }
}
