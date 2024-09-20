package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.TipoOcorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import lombok.Data;

@Data
public class OcorrenciaResponseDTO {

	private String descricao;
    private Status status;
    private TipoOcorrencia tipoOcorrencia;
    private String usuarioCriadorNome; // Nome do usuário criador
    private Unidade unidade;
    private LocalDateTime data;
}
