package br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos;

import java.time.LocalDateTime;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import lombok.Data;

@Data
public class RelatorioRequestDTO {
    private Unidade unidade;
    private Status status;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    // Construtor privado
    private RelatorioRequestDTO(Builder builder) {
        this.unidade = builder.unidade;
        this.status = builder.status;
        this.descricao = builder.descricao;
        this.dataInicio = builder.dataInicio;
        this.dataFim = builder.dataFim;
    }

    // Classe Builder
    public static class Builder {
        private Unidade unidade;
        private Status status;
        private String descricao;
        private LocalDateTime dataInicio;
        private LocalDateTime dataFim;

        public Builder withUnidade(Unidade unidade) {
            this.unidade = unidade;
            return this;
        }

        public Builder withStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder withDataInicio(LocalDateTime dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder withDataFim(LocalDateTime dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public RelatorioRequestDTO build() {
            return new RelatorioRequestDTO(this);
        }
    }
}
