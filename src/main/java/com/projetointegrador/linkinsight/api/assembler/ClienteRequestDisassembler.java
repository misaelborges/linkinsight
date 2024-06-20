package com.projetointegrador.linkinsight.api.assembler;

import com.projetointegrador.linkinsight.api.dto.ClienteRequestDTO;
import com.projetointegrador.linkinsight.domain.models.Cidade;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toDomainObject(ClienteRequestDTO clienteRequestDTO) {
        return modelMapper.map(clienteRequestDTO, Cliente.class);
    }

    public void copyToDomainObject(ClienteRequestDTO clienteRequestDTO, Cliente cliente) {
        if (cliente.getEndereco() != null) {
            cliente.getEndereco().setCidade(new Cidade());
        }

        modelMapper.map(clienteRequestDTO, cliente);
    }

}
