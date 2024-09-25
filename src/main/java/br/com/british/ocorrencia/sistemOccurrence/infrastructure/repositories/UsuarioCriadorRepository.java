package br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.UsuarioCriador;

public interface UsuarioCriadorRepository extends JpaRepository<UsuarioCriador, Long> {

	
	// Consulta JPQL para buscar o nome do usuário criador pelo ID
    @Query("SELECT u.nome FROM UsuarioCriador u WHERE u.id = :id")
    String findNomeById(@Param("id") Long id);
	
}
