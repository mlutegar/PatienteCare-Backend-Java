package com.br.patientecare.backend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.br.patientecare.backend.dto.LoginRequest;
import com.br.patientecare.backend.dto.LoginResponse;
import com.br.patientecare.entidades.Funcionario;
import com.br.patientecare.repository.FuncionarioRepository;

import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private String SECRET_KEY = "seu-segredo-aqui";

    public LoginResponse authenticate(LoginRequest loginRequest) {
        // Buscar o funcionário no banco de dados pelo email
        Funcionario funcionario = funcionarioRepository.findByEmail(loginRequest.getUsername());

        // Verificar se o funcionário existe e se a senha está correta
        if (funcionario != null && new BCryptPasswordEncoder().matches(loginRequest.getPassword(), funcionario.getSenha())) {
            // Gerar um token JWT
            String token = Jwts.builder()
                    .setSubject(funcionario.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia de validade
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            // Retornar o token no LoginResponse
            return new LoginResponse(token);
        } else {
            // Lançar uma exceção ou retornar uma resposta de erro
            throw new RuntimeException("Email ou senha inválidos");
        }
    }
}
