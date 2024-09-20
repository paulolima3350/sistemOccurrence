package br.com.british.ocorrencia.sistemOccurrence.domain.models.entities;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "usuariocreateder")
public class UsuarioCriador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    private Long matricula;
    private String nome;
    

}
