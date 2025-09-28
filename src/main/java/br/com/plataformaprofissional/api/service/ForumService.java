package br.com.plataformaprofissional.api.service;

import br.com.plataformaprofissional.api.model.Forum;
import br.com.plataformaprofissional.api.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ForumService {

    @Autowired
    private ForumRepository forumRepository;

    public List<Forum> findAll() {
        return forumRepository.findAll();
    }

    public Forum save(Forum forum) {
        return forumRepository.save(forum);
    }
}