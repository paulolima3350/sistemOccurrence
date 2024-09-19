package br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces;




import java.util.List;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;

public interface OcorrenciaDomainService {

	public OcorrenciaResponseDTO inserir(OcorrenciaRequestDTO request) throws Exception;
	
	
	public List<OcorrenciaResponseDTO> Consultar() throws Exception;
	


}
