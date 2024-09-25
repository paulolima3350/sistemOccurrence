package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciasPorUnidadeDTO {
    private Long id;               // ID da ocorrência
    private String descricao;      // Descrição da ocorrência
    private LocalDateTime data;    // Data da ocorrência
    private String nomeUsuario;     // Nome do usuário criador
}