package br.com.plataformaprofissional.api.controller;

import br.com.plataformaprofissional.api.model.Forum;
import br.com.plataformaprofissional.api.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forums")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @GetMapping
    public List<Forum> getAllForums() {
        return forumService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Forum createForum(@RequestBody Forum forum) {
        return forumService.save(forum);
    }
}