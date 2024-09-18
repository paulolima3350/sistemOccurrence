package br.com.british.ocorrencia.sistemOccurrence.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces.OcorrenciaDomainService;


@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaControler {
	
	@Autowired
	private OcorrenciaDomainService ocorrenciaDomainService;
	
	
	
	@PostMapping
	public OcorrenciaResponseDTO post(@RequestBody OcorrenciaRequestDTO request)throws Exception{
		
		System.out.println("to enviando isso" + request);
		return ocorrenciaDomainService.inserir(request);
		
	}
	
	
	
}
