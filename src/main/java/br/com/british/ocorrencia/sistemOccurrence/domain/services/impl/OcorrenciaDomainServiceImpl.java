package br.com.british.ocorrencia.sistemOccurrence.domain.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciasPorUnidadeDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.UsuarioCriador;
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

	    // Defina o usuário criador na ocorrência usando o método correto
	    ocorrencia.setUsuarioCriado(usuarioCriador); // Corrigido: usar o método correto

	    // Salve a ocorrência no banco de dados
	    ocorrenciaRepository.save(ocorrencia);

	    // Mapeie a ocorrência salva para o DTO de resposta
	    OcorrenciaResponseDTO response = modelMapper.map(ocorrencia, OcorrenciaResponseDTO.class);

	    // Preencher manualmente o nome do usuário criador
	    String nomeUsuarioCriador = usuarioCriador.getNome();
	    
	    // ou usar o método do repositório se preferir
	    response.setUsuarioCriadorNome(nomeUsuarioCriador);

	    return response;
	}
	
	// Método para consultar ocorrências por unidade
	@Override
	public List<OcorrenciasPorUnidadeDTO> consultarPorUnidade(Unidade unidade) {
	    // A chamada ao repositório agora usa o enum diretamente
	    List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByUnidade(unidade);

	    // Mapeando as ocorrências para o DTO de resposta
	    return ocorrencias.stream()
	            .map(ocorrencia -> modelMapper.map(ocorrencia, OcorrenciasPorUnidadeDTO.class))
	            .collect(Collectors.toList());
	}
    
    

    // Método para gerar relatório com filtros (unidade, status, datas)
    @Override
    public List<OcorrenciaResponseDTO> gerarRelatorio(String unidade, String status, String dataInicio, String dataFim) {
        LocalDateTime inicio = LocalDateTime.parse(dataInicio);
        LocalDateTime fim = LocalDateTime.parse(dataFim);

        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findByUnidadeAndStatusAndDataBetween(unidade, status, inicio, fim);
        
        // Mapeando as ocorrências para o DTO de resposta
        return ocorrencias.stream()
                .map(ocorrencia -> modelMapper.map(ocorrencia, OcorrenciaResponseDTO.class))
                .collect(Collectors.toList());
    }
}
	
	
	
	
	
	

