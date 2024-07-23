package com.br.patientecare.repository;

import com.br.patientecare.entidades.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}