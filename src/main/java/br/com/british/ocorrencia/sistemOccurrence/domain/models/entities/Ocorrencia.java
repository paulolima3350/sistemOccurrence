package br.com.british.ocorrencia.sistemOccurrence.domain.models.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Status;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.TipoOcorrencia;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ocorrencias") // Nome da tabela no banco de dados
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Estratégia de geração do ID
	@Column(name = "id") // Nome da coluna para o ID
	private Long id;

	@Column(name = "descricao") // Nome da coluna para o nome
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "status") // Nome da coluna para o status
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_ocorrencia") // Nome da coluna para o tipo de ocorrência
	private TipoOcorrencia tipoOcorrencia;

	@ManyToOne
	@JoinColumn(name = "usuario_criador_id") // Nome da coluna para a chave estrangeira do usuário criador
	private UsuarioCriador usuarioCriado;

	@Enumerated(EnumType.STRING)
	@Column(name = "unidade") // Nome da coluna para a unidade
	private Unidade unidade;

	@Column(name = "data") // Nome da coluna para a data
	private LocalDateTime data; // Usando LocalDateTime para data e hora

}
