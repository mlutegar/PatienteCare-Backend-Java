package com.br.patientecare.repository;

import com.br.patientecare.entidades.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
