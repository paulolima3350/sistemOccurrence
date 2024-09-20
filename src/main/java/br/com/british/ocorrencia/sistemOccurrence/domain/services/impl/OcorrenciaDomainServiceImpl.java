package br.com.british.ocorrencia.sistemOccurrence.domain.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.UsuarioCriador;
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

	
	

	
	public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception {
	    // Primeiro, busque o UsuarioCriador pelo ID
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

	    return response;
	}






	@Override
	public List<OcorrenciaResponseDTO> Consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
