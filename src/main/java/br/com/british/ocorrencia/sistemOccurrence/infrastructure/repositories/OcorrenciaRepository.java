package br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{

}
