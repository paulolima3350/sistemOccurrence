package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.TipoOcorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import lombok.Data;

@Data
public class OcorrenciaRequestDTO {

	private String descricao;
    private Status status;
    private TipoOcorrencia tipoOcorrencia;
    private Long usuarioCriadorId; // Verifique se está como UUID
    private Unidade unidade;
    private LocalDateTime data;

}