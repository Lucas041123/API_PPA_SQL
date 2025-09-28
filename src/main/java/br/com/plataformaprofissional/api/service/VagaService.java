package br.com.plataformaprofissional.api.service;

import br.com.plataformaprofissional.api.model.Vaga;
import br.com.plataformaprofissional.api.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> findById(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga save(Vaga vaga) {
        // Aqui poderíamos adicionar lógicas de negócio, como validações,
        // antes de salvar a vaga.
        return vagaRepository.save(vaga);
    }

    public void deleteById(Long id) {
        vagaRepository.deleteById(id);
    }
}