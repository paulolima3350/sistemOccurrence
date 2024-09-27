package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.TipoOcorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import lombok.Data;

@Data
public class OcorrenciaRequestDTO {
    
    private Status status;
    private TipoOcorrencia tipoOcorrencia;
    private Long usuarioCriadorId; 
    private Unidade unidade;
    private LocalDateTime data;

  
}