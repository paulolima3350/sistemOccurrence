package br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces;

import java.time.LocalDateTime;
import java.util.List;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciasPorUnidadeDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.RelatorioRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.RelatorioResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;

public interface OcorrenciaDomainService {

	// Inserção de nova ocorrência
	public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception;

	// Consulta por unidade
	public List<OcorrenciasPorUnidadeDTO> consultarPorUnidade(Unidade unidade);

	

	
	List<RelatorioResponseDTO> gerarRelatorio(Unidade unidade, Status status, LocalDateTime dataInicio,
			LocalDateTime dataFim);


	
	
	
	

}
