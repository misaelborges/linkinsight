package com.projetointegrador.linkinsight.api.controllers;

import com.projetointegrador.linkinsight.api.assembler.ClienteRequestDisassembler;
import com.projetointegrador.linkinsight.api.assembler.ClienteResponseAssembler;
import com.projetointegrador.linkinsight.api.dto.LoginResponseDTO;
import com.projetointegrador.linkinsight.api.dto.ClienteRequestDTO;
import com.projetointegrador.linkinsight.api.dto.ClienteResponseDTO;
import com.projetointegrador.linkinsight.api.dto.ResponseRegisterDTO;
import com.projetointegrador.linkinsight.domain.exception.ClienteNaoEncontradoException;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import com.projetointegrador.linkinsight.domain.repositories.IClienteRepository;
import com.projetointegrador.linkinsight.domain.services.ClienteService;
import com.projetointegrador.linkinsight.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permitir requisições de http://127.0.0.1:5500
public class ClienteController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

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

//    @PostMapping
//    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO clienteRequestDTO) {
//        Cliente cliente = clienteDisassembler.toDomainObject(clienteRequestDTO);
//        register(clienteRequestDTO, cliente);
//        return clienteAssembler.toModel(clienteService.salvar(cliente));
//    }

    @PostMapping
    public ClienteResponseDTO salvar(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteDisassembler.toDomainObject(clienteRequestDTO);
        cliente.setSenha(passwordEncoder.encode(clienteRequestDTO.getSenha()));
        return clienteAssembler.toModel(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ClienteResponseDTO atualizar(@PathVariable Long id, @RequestBody ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteService.buscador(id);
        clienteDisassembler.copyToDomainObject(clienteRequestDTO, cliente);
        return clienteAssembler.toModel(clienteService.salvar(cliente));
    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody ClienteRequestDTO body) {
//        Cliente cliente = clienteRepository.findByEmail(body.getEmail()).orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não foi encontrado"));
//        if (passwordEncoder.matches(body.getSenha(), cliente.getSenha())) {
//            String token = tokenService.geradorToken(cliente);
//            return ResponseEntity.ok(new LoginResponseDTO(cliente.getNome(), token));
//        }
//        return ResponseEntity.badRequest().build();
//    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody ClienteRequestDTO body) {
        Cliente cliente = clienteRepository.findByEmail(body.getEmail()).orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não foi encontrado"));
        if (passwordEncoder.matches(body.getSenha(), cliente.getSenha())) {
            String token = tokenService.geradorToken(cliente);
            return ResponseEntity.ok(new LoginResponseDTO(cliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

//    public void register(@RequestBody ClienteRequestDTO body, Cliente cliente) {
//        Optional<Cliente> usuario = clienteRepository.findByEmail(body.getEmail());
//
//        if (usuario.isEmpty()) {
//            Cliente novoCliente = new Cliente();
//            novoCliente.setSenha(passwordEncoder.encode(body.getSenha()));
//            novoCliente.setEmail(body.getEmail());
//
//            String token = this.tokenService.geradorToken(novoCliente);
//            System.out.println("Token: " + token);
//            ResponseEntity.ok(new ResponseRegisterDTO(novoCliente.getEmail(), token));
//        }
//
//        ResponseEntity.badRequest().build();
//    }

    public void register(@RequestBody ClienteRequestDTO body, Cliente cliente) {
        Optional<Cliente> usuario = clienteRepository.findByEmail(body.getEmail());

        if (usuario.isEmpty()) {
            cliente.setSenha(passwordEncoder.encode(body.getSenha()));
            cliente.setEmail(body.getEmail());

            String token = this.tokenService.geradorToken(cliente);
            System.out.println("Token: " + token);
            clienteRepository.save(cliente); // Salva o cliente com a senha hasheada
            ResponseEntity.ok(new ResponseRegisterDTO(cliente.getEmail(), token));
        }

        ResponseEntity.badRequest().build();
    }

}
