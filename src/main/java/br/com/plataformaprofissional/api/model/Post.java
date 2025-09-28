package br.com.plataformaprofissional.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String conteudo;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Vários posts podem pertencer a um usuário (autor)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario autor;

    // Vários posts podem pertencer a um fórum
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "forum_id")
    @JsonIgnore // Evita serialização recursiva ao buscar posts
    private Forum forum;
}