package br.com.plataformaprofissional.api.controller;

import br.com.plataformaprofissional.api.model.Usuario;
import br.com.plataformaprofissional.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuarios") // Define a URL base para todos os endpoints deste controlador
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para buscar todos os usuários
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    // Endpoint para buscar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo usuário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) { // Adicione @Valid aqui
        return usuarioService.save(usuario);
    }
}