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

    private String nome;
    private String descricao;

    @ElementCollection
    private List<String> substancias;

    @ElementCollection
    private List<String> materiais;

    @ElementCollection
    private List<String> naoRecomendado;

    // Construtor sem argumentos
    public Procedimento() {
    }

    // Construtor com argumentos
    public Procedimento(String nome, String descricao, List<String> substancias, List<String> materiais, List<String> naoRecomendado) {
        this.nome = nome;
        this.descricao = descricao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public List<String> getNaoRecomendado() {
        return naoRecomendado;
    }

    public void setNaoRecomendado(List<String> naoRecomendado) {
        this.naoRecomendado = naoRecomendado;
    }
}
