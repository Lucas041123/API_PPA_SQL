package br.com.plataformaprofissional.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vagas")
@Data
@NoArgsConstructor
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome; // Baseado em vaga['name']

    private String localizacao; // Baseado em vaga['locations'][0]['name']

    @Lob // Large Object - indica que este campo pode armazenar um texto longo
    @Column(columnDefinition = "TEXT")
    private String descricao; // Baseado em vaga['contents']

    private boolean ativa = true;
}