package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Libro;
import com.clublectura.Backend_ClubLectura.Service.ILibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/GCL/libro")


public class LibroController {

    @Autowired
    private ILibroService libroService;

    @PostMapping("/insertar")
    public ResponseEntity<Libro> crearLibro(@Valid @RequestBody Libro libro) {
        return new ResponseEntity<>(libroService.crear(libro), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Libro>> listarLibros() {
        return new ResponseEntity<>(libroService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Integer id) {
        return new ResponseEntity<>(libroService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable Integer id) {
        libroService.eliminar(id);
        return new ResponseEntity<>("Libro eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Integer id,
                                                  @Valid @RequestBody Libro libro) {
        Libro actualizado = libroService.actualizar(id, libro);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
