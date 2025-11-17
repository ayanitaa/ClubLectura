package com.clublectura.Backend_ClubLectura.Exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ReglasClubException.class)
    public ResponseEntity<Map<String, String>> manejarReglasClub(ReglasClubException ex) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<Map<String, String>> manejarNoEncontrado(RecursoNoEncontradoException ex) {

        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("error", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }
}
