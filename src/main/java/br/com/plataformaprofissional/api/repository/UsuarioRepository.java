package br.com.plataformaprofissional.api.repository;

import br.com.plataformaprofissional.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar um usuário pelo email (será usado no login)
    Optional<Usuario> findByEmail(String email);
}