package br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.UsuarioCriador;

public interface UsuarioCriadorRepository extends JpaRepository<UsuarioCriador, Long> {

}
