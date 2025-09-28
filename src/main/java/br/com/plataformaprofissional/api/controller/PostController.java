package br.com.plataformaprofissional.api.controller;

import br.com.plataformaprofissional.api.model.Post;
import br.com.plataformaprofissional.api.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // O ID do autor viria do token de autenticação no futuro. Por agora, passamos na requisição.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestParam Long forumId, @RequestParam Long autorId, @RequestBody Post post) {
        return postService.createPost(forumId, autorId, post);
    }
}