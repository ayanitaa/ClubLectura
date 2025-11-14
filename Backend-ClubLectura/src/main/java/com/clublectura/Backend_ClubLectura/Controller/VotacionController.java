package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Votacion;
import com.clublectura.Backend_ClubLectura.Service.IVotacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/votacion")

public class VotacionController {
    
    @Autowired
    private IVotacionService votacionService;

    @PostMapping("/insertar")
    public ResponseEntity<Votacion> crearVotacion(@Valid @RequestBody Votacion votacion) {
        return new ResponseEntity<>(votacionService.crear(votacion), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Votacion>> listarVotaciones() {
        return new ResponseEntity<>(votacionService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Votacion> buscarVotacion(@PathVariable Integer id) {
        return new ResponseEntity<>(votacionService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarVotacion(@PathVariable Integer id) {
        votacionService.eliminar(id);
        return new ResponseEntity<>("Votación eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Votacion> actualizarVotacion(@PathVariable Integer id,
                                                  @Valid @RequestBody Votacion votacion) {
        Votacion actualizado = votacionService.actualizar(id, votacion);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
