package com.projetointegrador.linkinsight.domain.services;

import com.projetointegrador.linkinsight.domain.exception.ClienteNaoEncontradoException;
import com.projetointegrador.linkinsight.domain.exception.NegocioException;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import com.projetointegrador.linkinsight.domain.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscador(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
    }
}
