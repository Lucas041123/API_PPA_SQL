package br.com.plataformaprofissional.api.handler;

import br.com.plataformaprofissional.api.dto.ErrorResponse;
import br.com.plataformaprofissional.api.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice // Anotação que torna esta classe um "apanhador" global de exceções
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class) // Especifica que este método trata exceções de validação
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<ValidationError> erros = ex.getBindingResult().getAllErrors().stream()
                .map(error -> {
                    String nomeCampo = ((FieldError) error).getField();
                    String mensagemErro = error.getDefaultMessage();
                    return new ValidationError(nomeCampo, mensagemErro);
                })
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                "Erro de validação",
                HttpStatus.BAD_REQUEST.value(),
                erros
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}