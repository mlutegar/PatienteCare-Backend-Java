package com.br.patientecare.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Procedimento procedimento;

    private String horario;
    private String data; // Data do agendamento

    @ManyToOne
    private Paciente paciente;

    private String tipoAtendimento;
    private String convenioPlano;

    // Construtor sem argumentos
    public Atendimento() {
    }

    // Construtor com argumentos
    public Atendimento(Procedimento procedimento, String horario, String data, Paciente paciente, String tipoAtendimento, String convenioPlano) {
        this.procedimento = procedimento;
        this.horario = horario;
        this.data = data;
        this.paciente = paciente;
        this.tipoAtendimento = tipoAtendimento;
        this.convenioPlano = convenioPlano;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getConvenioPlano() {
        return convenioPlano;
    }

    public void setConvenioPlano(String convenioPlano) {
        this.convenioPlano = convenioPlano;
    }
}
