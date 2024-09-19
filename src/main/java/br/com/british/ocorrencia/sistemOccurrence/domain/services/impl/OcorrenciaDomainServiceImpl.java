package br.com.british.ocorrencia.sistemOccurrence.domain.services.impl;

import java.awt.JobAttributes.DestinationType;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.entities.Ocorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces.OcorrenciaDomainService;
import br.com.british.ocorrencia.sistemOccurrence.infrastructure.repositories.OcorrenciaRepository;

@Service
public class OcorrenciaDomainServiceImpl implements OcorrenciaDomainService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	
	
	
	
	@Override
	public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception {
	
		
		Ocorrencia ocorrencia = modelMapper.map(request, Ocorrencia.class);
		ocorrencia.setId(UUID.randomUUID());

		
		ocorrenciaRepository.save(ocorrencia);
		
	
		OcorrenciaResponseDTO response = modelMapper.map(ocorrencia, OcorrenciaResponseDTO.class);
		
				
		
		return response;
		
			
	}






	@Override
	public List<OcorrenciaResponseDTO> Consultar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
