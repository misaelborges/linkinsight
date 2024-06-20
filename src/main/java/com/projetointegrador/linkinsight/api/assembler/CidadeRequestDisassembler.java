package com.projetointegrador.linkinsight.api.assembler;

import com.projetointegrador.linkinsight.api.dto.CidadeRequestDTO;
import com.projetointegrador.linkinsight.domain.models.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeRequestDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeRequestDTO cidadeRequestDTO) {
        return modelMapper.map(cidadeRequestDTO, Cidade.class);
    }

    public void copyToDomainObject(CidadeRequestDTO cidadeRequestDTO, Cidade cidade) {
        modelMapper.map(cidadeRequestDTO, cidade);
    }
}
