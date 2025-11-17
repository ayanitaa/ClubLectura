package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Inscripcion;
import com.clublectura.Backend_ClubLectura.Service.IInscripcionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/inscripcion")

public class InscripcionController {
    
    @Autowired
    private IInscripcionService inscripcionService;

    @PostMapping("/insertar")
    public ResponseEntity<Inscripcion> crearInscripcion(@Valid @RequestBody Inscripcion inscripcion) {
        return new ResponseEntity<>(inscripcionService.crear(inscripcion), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Inscripcion>> listarInscripciones() {
        return new ResponseEntity<>(inscripcionService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Inscripcion> buscarInscripcion(@PathVariable Integer id) {
        return new ResponseEntity<>(inscripcionService.obtener(id), HttpStatus.OK);
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<String> cancelarInscripcion(@PathVariable Integer id) {
        return new ResponseEntity<>(inscripcionService.cancelar(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Inscripcion> actualizarInscripcion(@PathVariable Integer id,
                                                  @Valid @RequestBody Inscripcion inscripcion) {
        Inscripcion actualizado = inscripcionService.actualizar(id, inscripcion);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
