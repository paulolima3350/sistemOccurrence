package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioResponseDTO {
    private Long id;            // ID da ocorrência
    private String unidade;     // Ou Unidade se for um enum
    private String status;      // Ou Status se for um enum
    private LocalDateTime data; // Data da ocorrência
    private String descricao;   // Descrição da ocorrência
}
