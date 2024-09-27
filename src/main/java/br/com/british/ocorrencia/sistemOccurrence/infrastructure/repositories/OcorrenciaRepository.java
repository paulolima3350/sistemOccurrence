package br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

	@Query(value = "SELECT o.id, o.descricao, o.data, u.nome AS nome_usuario " + "FROM ocorrencias o "
			+ "JOIN usuariocreateder u ON o.usuario_criador_id = u.id_user "
			+ "WHERE o.unidade = :unidade", nativeQuery = true)
	List<Object[]> findOcorrenciasByUnidade(@Param("unidade") String unidade);

// Método para buscar por unidade
	List<Ocorrencia> findByUnidade(Unidade unidade);

	 @Query("SELECT o FROM Ocorrencia o WHERE o.unidade = :unidade AND o.status = :status AND o.data BETWEEN :dataInicio AND :dataFim")
	    List<Ocorrencia> findByUnidadeAndStatusAndDataBetween(
	        @Param("unidade") Unidade unidade,
	        @Param("status") Status status,
	        @Param("dataInicio") LocalDateTime dataInicio,
	        @Param("dataFim") LocalDateTime dataFim
	    );

}