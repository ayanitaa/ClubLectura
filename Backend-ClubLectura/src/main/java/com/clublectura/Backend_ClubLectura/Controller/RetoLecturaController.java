package com.clublectura.Backend_ClubLectura.Controller;

import com.clublectura.Backend_ClubLectura.Model.RetoLectura;
import com.clublectura.Backend_ClubLectura.Service.IRetoLecturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/GCL/retoLectura")


public class RetoLecturaController {
    @Autowired
    private IRetoLecturaService retoLecturaService;

    @PostMapping("/insertar")
    public ResponseEntity<RetoLectura> crearReto(@Valid @RequestBody RetoLectura reto) {
        return new ResponseEntity<>(retoLecturaService.crear(reto), HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<RetoLectura>> listarRetos() {
        return new ResponseEntity<>(retoLecturaService.listar(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<RetoLectura> buscarReto(@PathVariable Integer id) {
        return new ResponseEntity<>(retoLecturaService.obtener(id), HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarReto(@PathVariable Integer id) {
        retoLecturaService.eliminar(id);
        return new ResponseEntity<>("Reto eliminado correctamente", HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RetoLectura> actualizarReto(@PathVariable Integer id,
                                                      @Valid @RequestBody RetoLectura reto) {
        RetoLectura actualizado = retoLecturaService.actualizar(id, reto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
