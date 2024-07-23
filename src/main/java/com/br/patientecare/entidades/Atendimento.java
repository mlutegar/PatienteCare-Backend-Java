package com.br.patientecare.entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String procedimento;
    private String horario;
    private String data;
    private String paciente;

    @ElementCollection
    private List<String> substancias;

    @ElementCollection
    private List<String> materiais;

    // Construtor sem argumentos
    public Atendimento() {
    }

    // Construtor com argumentos
    public Atendimento(String procedimento, String horario, String data, String paciente, List<String> substancias, List<String> materiais) {
        this.procedimento = procedimento;
        this.horario = horario;
        this.data = data;
        this.paciente = paciente;
        this.substancias = substancias;
        this.materiais = materiais;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public List<String> getSubstancias() {
        return substancias;
    }

    public void setSubstancias(List<String> substancias) {
        this.substancias = substancias;
    }

    public List<String> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<String> materiais) {
        this.materiais = materiais;
    }
}
