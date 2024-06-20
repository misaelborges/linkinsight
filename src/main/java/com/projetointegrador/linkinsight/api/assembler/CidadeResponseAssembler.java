package com.projetointegrador.linkinsight.api.assembler;

import com.projetointegrador.linkinsight.api.dto.CidadeResponseDTO;
import com.projetointegrador.linkinsight.domain.models.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeResponseAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CidadeResponseDTO toModel(Cidade cidade) {
        return modelMapper.map(cidade, CidadeResponseDTO.class);
    }

    public List<CidadeResponseDTO> toCollectionModel(List<Cidade> cidades) {
        return cidades.stream().map(this::toModel).collect(Collectors.toList());
    }

}
