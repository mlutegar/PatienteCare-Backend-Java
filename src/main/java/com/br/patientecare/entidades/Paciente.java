package com.br.patientecare.entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String genero;
    private String dataNascimento;
    private String contato;
    private String email;
    private String cpf;
    private String rg;

    @ElementCollection
    private List<String> alergias;

    @ElementCollection
    private List<String> medicamentosEmUso;

    @ElementCollection
    private List<String> condicoesPreexistentes;

    // Getters e Setters
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<String> getMedicamentosEmUso() {
        return medicamentosEmUso;
    }

    public void setMedicamentosEmUso(List<String> medicamentosEmUso) {
        this.medicamentosEmUso = medicamentosEmUso;
    }

    public List<String> getCondicoesPreexistentes() {
        return condicoesPreexistentes;
    }

    public void setCondicoesPreexistentes(List<String> condicoesPreexistentes) {
        this.condicoesPreexistentes = condicoesPreexistentes;
    }
}
