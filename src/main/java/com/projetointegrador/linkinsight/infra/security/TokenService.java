package com.projetointegrador.linkinsight.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.projetointegrador.linkinsight.domain.models.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String chaveSecreta;

    public String geradorToken(Cliente cliente) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);

            return JWT.create()
                    .withIssuer("linkinsight")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(this.geradorDataExpiracaoToken())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro enquanto autenticava " + e.getMessage());
        }
    }

    public String validadorToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(chaveSecreta);

            return JWT.require(algorithm)
                    .withIssuer("linkinsight")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    private Instant geradorDataExpiracaoToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
