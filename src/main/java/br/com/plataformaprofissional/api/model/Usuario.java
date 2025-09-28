package br.com.plataformaprofissional.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.") // Garante que o campo não é nulo nem vazio
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres.")
    private String nome;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O formato do email é inválido.") // Valida o formato do email
    @Column(unique = true) // Garante que o email seja único no banco de dados
    private String email;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 4, message = "A senha deve ter no mínimo 4 caracteres.")
    private String senha;

    private String empresa;
    @Lob
    private String bio;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "usuario_habilidades")
    @Column(name = "habilidade")
    private List<String> habilidades;

    private boolean ativo = true;
}