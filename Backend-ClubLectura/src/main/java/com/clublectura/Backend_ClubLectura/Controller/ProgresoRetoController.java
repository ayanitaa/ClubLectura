package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.ProgresoReto;
import com.clublectura.Backend_ClubLectura.Service.IProgresoRetoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/progresoReto")

public class ProgresoRetoController {
    
    @Autowired
    private IProgresoRetoService service;

    @GetMapping
    public List<ProgresoReto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgresoReto> obtenerProgreso(@PathVariable Integer id) {
        ProgresoReto progreso = service.obtener(id);
        return ResponseEntity.ok(progreso);
    }

    @PostMapping
    public ResponseEntity<ProgresoReto> crearProgreso(@Valid @RequestBody ProgresoReto progreso) {
        ProgresoReto nuevoProgreso = service.crear(progreso);
        return new ResponseEntity<>(nuevoProgreso, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgresoReto> actualizarProgreso(@PathVariable Integer id, @Valid @RequestBody ProgresoReto progreso) {
        ProgresoReto progresoActualizado = service.actualizar(id, progreso);
        return ResponseEntity.ok(progresoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProgreso(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}