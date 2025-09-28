package br.com.plataformaprofissional.api.controller;

import br.com.plataformaprofissional.api.model.Vaga;
import br.com.plataformaprofissional.api.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas") // URL base para os endpoints de vagas
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<Vaga> getAllVagas() {
        return vagaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> getVagaById(@PathVariable Long id) {
        return vagaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga createVaga(@RequestBody Vaga vaga) {
        return vagaService.save(vaga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaga(@PathVariable Long id) {
        // Verifica se a vaga existe antes de tentar deletar
        if (vagaService.findById(id).isPresent()) {
            vagaService.deleteById(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }
    }
}