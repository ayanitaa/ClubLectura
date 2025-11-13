package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Resena;
import com.clublectura.Backend_ClubLectura.Service.IResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/GCL/resena")

public class ResenaController {
    
    @Autowired
    private IResenaService resenaService;

    @PostMapping("/insertar")
    public ResponseEntity<Resena> crearResena(@Valid @RequestBody Resena resena) {
        return new ResponseEntity<>(resenaService.crear(resena), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Resena>> listarResenas() {
        return new ResponseEntity<>(resenaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Resena> buscarResena(@PathVariable Integer id) {
        return new ResponseEntity<>(resenaService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarResena(@PathVariable Integer id) {
        resenaService.eliminar(id);
        return new ResponseEntity<>("Reseña eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable Integer id,
                                                  @Valid @RequestBody Resena resena) {
        Resena actualizado = resenaService.actualizar(id, resena);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
