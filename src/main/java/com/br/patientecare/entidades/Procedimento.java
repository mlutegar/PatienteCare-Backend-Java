package com.br.patientecare.entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProcedimento;
    private String descricaoProcedimento;

    @ElementCollection
    private List<String> substancias;

    @ElementCollection
    private List<String> materiais;

    private String naoRecomendado;

    // Construtor sem argumentos
    public Procedimento() {
    }

    // Construtor com argumentos
    public Procedimento(String nomeProcedimento, String descricaoProcedimento, List<String> substancias, List<String> materiais, String naoRecomendado) {
        this.nomeProcedimento = nomeProcedimento;
        this.descricaoProcedimento = descricaoProcedimento;
        this.substancias = substancias;
        this.materiais = materiais;
        this.naoRecomendado = naoRecomendado;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public String getDescricaoProcedimento() {
        return descricaoProcedimento;
    }

    public void setDescricaoProcedimento(String descricaoProcedimento) {
        this.descricaoProcedimento = descricaoProcedimento;
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

    public String getNaoRecomendado() {
        return naoRecomendado;
    }

    public void setNaoRecomendado(String naoRecomendado) {
        this.naoRecomendado = naoRecomendado;
    }
}
