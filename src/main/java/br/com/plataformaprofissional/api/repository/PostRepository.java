package br.com.plataformaprofissional.api.repository;

import br.com.plataformaprofissional.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Chama a procedure 'registrar_novo_post' no banco de dados Oracle.
     * O Spring Data JPA mapeia automaticamente os parâmetros do método para os parâmetros da procedure.
     * O nome do parâmetro de saída da procedure não é necessário aqui, pois a procedure o retorna implicitamente.
     * No entanto, o Spring espera um valor de retorno, que neste caso será o ID do novo post.
     */
    @Procedure(procedureName = "PKG_FORUM.registrar_novo_post")
    Integer registrarNovoPost(
            @Param("p_titulo") String titulo,
            @Param("p_conteudo") String conteudo,
            @Param("p_usuario_id") Long usuarioId,
            @Param("p_forum_id") Long forumId
    );
}