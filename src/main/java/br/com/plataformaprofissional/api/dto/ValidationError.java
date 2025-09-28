package br.com.plataformaprofissional.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // Cria um construtor com todos os argumentos
public class ValidationError {
    private String campo;
    private String mensagem;
}