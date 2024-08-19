package com.br.patientecare.backend.controller;

import com.br.patientecare.entidades.Paciente;
import com.br.patientecare.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public Paciente createPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            Paciente pacienteAtualizado = paciente.get();
            pacienteAtualizado.setNomeCompleto(pacienteDetails.getNomeCompleto());
            pacienteAtualizado.setGenero(pacienteDetails.getGenero());
            pacienteAtualizado.setDataNascimento(pacienteDetails.getDataNascimento());
            pacienteAtualizado.setContato(pacienteDetails.getContato());
            pacienteAtualizado.setEmail(pacienteDetails.getEmail());
            pacienteAtualizado.setCpf(pacienteDetails.getCpf());
            pacienteAtualizado.setRg(pacienteDetails.getRg());
            pacienteAtualizado.setAlergias(pacienteDetails.getAlergias());
            pacienteAtualizado.setMedicamentosEmUso(pacienteDetails.getMedicamentosEmUso());
            pacienteAtualizado.setCondicoesPreexistentes(pacienteDetails.getCondicoesPreexistentes());
            return ResponseEntity.ok(pacienteRepository.save(pacienteAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isPresent()) {
            pacienteRepository.delete(paciente.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
