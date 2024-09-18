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
    @Column(name = "id_user", columnDefinition = "BINARY(16)")
    private UUID idUser;

    private String nome;

    // Default constructor required by JPA
    public UsuarioCriador() {
    }

    // Parameterized constructor for convenience (optional)
    public UsuarioCriador(UUID idUser, String nome) {
        this.idUser = idUser;
        this.nome = nome;
    }
}
