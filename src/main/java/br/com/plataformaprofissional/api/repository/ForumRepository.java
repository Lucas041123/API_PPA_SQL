package br.com.plataformaprofissional.api.repository;

import br.com.plataformaprofissional.api.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
}