package com.br.patientecare.backend.controller;

import com.br.patientecare.entidades.Procedimento;
import com.br.patientecare.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    @GetMapping
    public List<Procedimento> getAllProcedimentos() {
        return procedimentoRepository.findAll();
    }

    @PostMapping
    public Procedimento createProcedimento(@RequestBody Procedimento procedimento) {
        return procedimentoRepository.save(procedimento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> getProcedimentoById(@PathVariable Long id) {
        Optional<Procedimento> procedimento = procedimentoRepository.findById(id);
        if (procedimento.isPresent()) {
            return ResponseEntity.ok(procedimento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedimento> updateProcedimento(@PathVariable Long id, @RequestBody Procedimento procedimentoDetails) {
        Optional<Procedimento> procedimento = procedimentoRepository.findById(id);
        if (procedimento.isPresent()) {
            Procedimento procedimentoAtualizado = procedimento.get();
            procedimentoAtualizado.setNome(procedimentoDetails.getNome());
            procedimentoAtualizado.setDescricao(procedimentoDetails.getDescricao());
            procedimentoAtualizado.setSubstancias(procedimentoDetails.getSubstancias());
            procedimentoAtualizado.setMateriais(procedimentoDetails.getMateriais());
            procedimentoAtualizado.setNaoRecomendado(procedimentoDetails.getNaoRecomendado());
            return ResponseEntity.ok(procedimentoRepository.save(procedimentoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProcedimento(@PathVariable Long id) {
        Optional<Procedimento> procedimento = procedimentoRepository.findById(id);
        if (procedimento.isPresent()) {
            procedimentoRepository.delete(procedimento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
