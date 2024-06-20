package com.projetointegrador.linkinsight.api.controllers;

import com.projetointegrador.linkinsight.api.assembler.ClienteRequestDisassembler;
import com.projetointegrador.linkinsight.api.assembler.ClienteResponseAssembler;
import com.projetointegrador.linkinsight.api.dto.ClienteRequestDTO;
import com.projetointegrador.linkinsight.api.dto.ClienteResponseDTO;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import com.projetointegrador.linkinsight.domain.repositories.IClienteRepository;
import com.projetointegrador.linkinsight.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteResponseAssembler clienteAssembler;

    @Autowired
    private ClienteRequestDisassembler clienteDisassembler;

    @GetMapping
    public List<ClienteResponseDTO> listarTodos() {
        return clienteAssembler.toCollectionModel(clienteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ClienteResponseDTO buscarPorId(@PathVariable Long id) {
        return clienteAssembler.toModel(clienteService.buscador(id));
    }

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteDisassembler.toDomainObject(clienteRequestDTO);
        return clienteAssembler.toModel(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteService.buscador(id);
        clienteDisassembler.copyToDomainObject(clienteRequestDTO, cliente);
        return clienteAssembler.toModel(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public void desativar(@PathVariable Long id) {
        clienteService.desativarCliente(id);
    }

}
