package br.com.plataformaprofissional.api.repository;

import br.com.plataformaprofissional.api.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    // O JpaRepository já nos fornece métodos como findAll(), findById(), save(), etc.
    // Podemos adicionar métodos de busca customizados aqui no futuro, se necessário.
}