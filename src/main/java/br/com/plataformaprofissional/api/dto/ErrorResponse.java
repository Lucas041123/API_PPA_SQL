package br.com.plataformaprofissional.api.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class ErrorResponse {
    private final String mensagem;
    private final int status;
    private final List<ValidationError> erros;

    public ErrorResponse(String mensagem, int status, List<ValidationError> erros) {
        this.mensagem = mensagem;
        this.status = status;
        this.erros = erros;
    }
}