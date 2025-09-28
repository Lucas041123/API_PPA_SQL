package br.com.plataformaprofissional.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "forums")
@Data
@NoArgsConstructor
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome; // "Flutter", "IA e Machine Learning", etc.

    private String descricao;

    // Um fórum pode ter vários posts
    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Post> posts;
}