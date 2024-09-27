package br.com.british.ocorrencia.sistemOccurrence.domain.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciasPorUnidadeDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.RelatorioResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.UsuarioCriador;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces.OcorrenciaDomainService;
import br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories.OcorrenciaRepository;
import br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories.UsuarioCriadorRepository;

@Service
public class OcorrenciaDomainServiceImpl implements OcorrenciaDomainService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;

	@Autowired
	private UsuarioCriadorRepository UsuarioCriadorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception {
	    // Buscar o UsuarioCriador pelo ID
	    UsuarioCriador usuarioCriador = UsuarioCriadorRepository.findById(request.getUsuarioCriadorId())
	            .orElseThrow(() -> new Exception("Usuário criador não encontrado"));

	    // Mapeie o DTO para a entidade Ocorrencia
	    Ocorrencia ocorrencia = modelMapper.map(request, Ocorrencia.class);

	    // Defina o usuário criador na ocorrência
	    ocorrencia.setUsuarioCriado(usuarioCriador);

	    // Salve a ocorrência no banco de dados
	    ocorrenciaRepository.save(ocorrencia);

	    // Mapeie a ocorrência salva para o DTO de resposta
	    OcorrenciaResponseDTO response = modelMapper.map(ocorrencia, OcorrenciaResponseDTO.class);

	    // Preencher manualmente o nome do usuário criador
	    String nomeUsuarioCriador = usuarioCriador.getNome();
	    response.setUsuarioCriadorNome(nomeUsuarioCriador);

	    return response;
	}



	// Método para consultar ocorrências por unidade
	@Override
	public List<OcorrenciasPorUnidadeDTO> consultarPorUnidade(Unidade unidade) {
		// A chamada ao repositório agora usa o enum diretamente
		List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByUnidade(unidade);

		// Mapeando as ocorrências para o DTO de resposta
		return ocorrencias.stream().map(ocorrencia -> modelMapper.map(ocorrencia, OcorrenciasPorUnidadeDTO.class))
				.collect(Collectors.toList());
	}

	// Método para gerar relatório com filtros (unidade, status, datas)
	@Override
	public List<RelatorioResponseDTO> gerarRelatorio(Unidade unidade, Status status, LocalDateTime dataInicio, LocalDateTime dataFim) {
	    // Lógica para buscar ocorrências com base nos parâmetros
	    List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByUnidadeAndStatusAndDataBetween(unidade, status, dataInicio, dataFim);

	    // Transformar as ocorrências em DTOs
	    List<RelatorioResponseDTO> relatorio = new ArrayList<>();
	    for (Ocorrencia ocorrencia : ocorrencias) {
	        RelatorioResponseDTO dto = new RelatorioResponseDTO();
	        dto.setId(ocorrencia.getId()); // Presumindo que Ocorrencia tem um método getId()
	        dto.setUnidade(ocorrencia.getUnidade().toString()); // Ou use um método apropriado
	        dto.setStatus(ocorrencia.getStatus().toString()); // Ou use um método apropriado
	        dto.setData(ocorrencia.getData()); // Presumindo que Ocorrencia tem um método getData()
	        dto.setDescricao(ocorrencia.getDescricao()); // A descrição da ocorrência

	        relatorio.add(dto);
	    }

	    return relatorio;
	}



	

}
