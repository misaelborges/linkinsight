package com.projetointegrador.linkinsight.infra.security;

import com.projetointegrador.linkinsight.domain.exception.ClienteNaoEncontradoException;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import com.projetointegrador.linkinsight.domain.repositories.IClienteRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    IClienteRepository clienteRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recuperarToken(request);
        var login = tokenService.validadorToken(token);

        if(login != null){
            Cliente cliente = clienteRepository.findByEmail(login).orElseThrow(() -> new ClienteNaoEncontradoException("Usuario não encontrado"));
            var autoridades = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var autenticacao = new UsernamePasswordAuthenticationToken(cliente, null, autoridades);
            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request){
        var cabecalhoAutenticacao = request.getHeader("Authorization");
        if(cabecalhoAutenticacao == null) return null;
        return cabecalhoAutenticacao.replace("Bearer ", "");
    }
}
