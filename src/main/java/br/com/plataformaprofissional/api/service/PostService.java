package br.com.plataformaprofissional.api.service;

import br.com.plataformaprofissional.api.model.Post;
import br.com.plataformaprofissional.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Removemos as injeções de ForumRepository e UsuarioRepository,
    // pois a lógica de validação de IDs agora está implícita na procedure.

    @Transactional
    public Post createPost(Long forumId, Long autorId, Post post) {
        // Chama a procedure do Oracle para inserir o post
        Integer novoPostId = postRepository.registrarNovoPost(
                post.getTitulo(),
                post.getConteudo(),
                autorId,
                forumId
        );

        // Após a procedure ser executada, buscamos o post recém-criado pelo ID retornado
        // para devolver o objeto completo na resposta da API.
        return postRepository.findById(novoPostId.longValue())
                .orElseThrow(() -> new RuntimeException("Falha ao criar e recuperar o post via procedure. ID retornado: " + novoPostId));
    }
}