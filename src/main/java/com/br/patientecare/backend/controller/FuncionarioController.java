package com.br.patientecare.backend.controller;

import com.br.patientecare.entidades.Funcionario;
import com.br.patientecare.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionarioDetails) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            Funcionario funcionarioAtualizado = funcionario.get();
            funcionarioAtualizado.setNomeCompleto(funcionarioDetails.getNomeCompleto());
            funcionarioAtualizado.setEmail(funcionarioDetails.getEmail());
            funcionarioAtualizado.setSenha(funcionarioDetails.getSenha());
            funcionarioAtualizado.setCargo(funcionarioDetails.getCargo());
            funcionarioAtualizado.setTelefone(funcionarioDetails.getTelefone());
            return ResponseEntity.ok(funcionarioRepository.save(funcionarioAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
