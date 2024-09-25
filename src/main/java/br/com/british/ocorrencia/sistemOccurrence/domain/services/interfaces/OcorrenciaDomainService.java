package br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces;

import java.util.List;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciasPorUnidadeDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;

public interface OcorrenciaDomainService {

	// Inserção de nova ocorrência
    public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception;

    // Consulta por unidade
    public List<OcorrenciasPorUnidadeDTO> consultarPorUnidade(Unidade unidade);

    // Gerar relatório com filtros (unidade, status, datas)
    public List<OcorrenciaResponseDTO> gerarRelatorio(String unidade, String status, String dataInicio, String dataFim);

	

}
