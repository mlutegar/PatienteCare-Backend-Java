package com.br.patientecare.backend.controller;

import com.br.patientecare.entidades.Atendimento;
import com.br.patientecare.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @GetMapping
    public List<Atendimento> getAllAtendimentos() {
        return atendimentoRepository.findAll();
    }

    @PostMapping
    public Atendimento createAtendimento(@RequestBody Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimentoById(@PathVariable Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isPresent()) {
            return ResponseEntity.ok(atendimento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody Atendimento atendimentoDetails) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isPresent()) {
            Atendimento atendimentoAtualizado = atendimento.get();
            atendimentoAtualizado.setProcedimento(atendimentoDetails.getProcedimento());
            atendimentoAtualizado.setHorario(atendimentoDetails.getHorario());
            atendimentoAtualizado.setDataAgendamento(atendimentoDetails.getDataAgendamento());
            atendimentoAtualizado.setPaciente(atendimentoDetails.getPaciente());
            atendimentoAtualizado.setTipoAtendimento(atendimentoDetails.getTipoAtendimento());
            atendimentoAtualizado.setConvenioPlano(atendimentoDetails.getConvenioPlano());
            return ResponseEntity.ok(atendimentoRepository.save(atendimentoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isPresent()) {
            atendimentoRepository.delete(atendimento.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
