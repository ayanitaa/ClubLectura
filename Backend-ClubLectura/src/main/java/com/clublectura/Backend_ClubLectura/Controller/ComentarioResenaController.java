package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.ComentarioResena;
import com.clublectura.Backend_ClubLectura.Service.IComentarioResenaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/comentarioResena")

public class ComentarioResenaController {

    @Autowired
    private IComentarioResenaService service;

    @PostMapping("/insertar")
    public ResponseEntity<ComentarioResena> crearComentarioResena(@Valid @RequestBody ComentarioResena comentario) {
        return new ResponseEntity<>(service.crear(comentario), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ComentarioResena>> listarComentariosResena() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioResena> buscarComentarioResena(@PathVariable Integer id) {
        return new ResponseEntity<>(service.obtener(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioResena> actualizarComentarioResena(@PathVariable Integer id,
                                                                            @Valid @RequestBody ComentarioResena comentario) {
        return new ResponseEntity<>(service.actualizar(id, comentario), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarComentarioResena(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>("Comentario de reseña eliminado correctamente", HttpStatus.OK);
    }
}