package com.clublectura.Backend_ClubLectura.Controller;

import com.clublectura.Backend_ClubLectura.Model.RetoLibro;
import com.clublectura.Backend_ClubLectura.Service.IRetoLibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GCL/retoLibro")
public class RetoLibroController {

    @Autowired
    private IRetoLibroService retoLibroService;

    @PostMapping("/insertar")
    public ResponseEntity<RetoLibro> crear(@Valid @RequestBody RetoLibro retoLibro) {
        RetoLibro creado = retoLibroService.crear(retoLibro);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<RetoLibro>> listar() {
        return new ResponseEntity<>(retoLibroService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idReto}/{idLibro}")
    public ResponseEntity<RetoLibro> obtener(@PathVariable Integer idReto,
                                             @PathVariable Integer idLibro) {
        return new ResponseEntity<>(retoLibroService.obtener(idReto, idLibro), HttpStatus.OK);
    }

    @GetMapping("/listar/reto/{idReto}")
    public ResponseEntity<List<RetoLibro>> listarPorReto(@PathVariable Integer idReto) {
        return new ResponseEntity<>(retoLibroService.listarPorReto(idReto), HttpStatus.OK);
    }

    @GetMapping("/listar/libro/{idLibro}")
    public ResponseEntity<List<RetoLibro>> listarPorLibro(@PathVariable Integer idLibro) {
        return new ResponseEntity<>(retoLibroService.listarPorLibro(idLibro), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{idReto}/{idLibro}")
    public ResponseEntity<String> eliminar(@PathVariable Integer idReto,
                                           @PathVariable Integer idLibro) {
        return new ResponseEntity<>(retoLibroService.eliminar(idReto, idLibro), HttpStatus.OK);
    }
}
