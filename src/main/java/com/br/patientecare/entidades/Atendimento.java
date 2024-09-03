package com.br.patientecare.entidades;

import jakarta.persistence.*;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Procedimento procedimento;

    private String horario;
    private String dataAgendamento; // Data do agendamento

    @ManyToOne
    private Paciente paciente;

    private String tipoAtendimento;
    private String convenioPlano;

    @Column(length = 1000)
    private String relatorio;

    @Column(length = 1000)
    private String respostaIA;
    // Construtor sem argumentos
    public Atendimento() {
    }

    // Construtor com argumentos
    public Atendimento(Procedimento procedimento, String horario, String dataAgendamento, Paciente paciente, String tipoAtendimento, String convenioPlano, String relatorio, String respostaIA) {
        this.procedimento = procedimento;
        this.horario = horario;
        this.dataAgendamento = dataAgendamento;
        this.paciente = paciente;
        this.tipoAtendimento = tipoAtendimento;
        this.convenioPlano = convenioPlano;
        this.relatorio = relatorio;
        this.respostaIA = respostaIA;
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

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
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

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getRespostaIA() {
        return respostaIA;
    }

    public void setRespostaIA(String respostaIA) {
        this.respostaIA = respostaIA;
    }
}
