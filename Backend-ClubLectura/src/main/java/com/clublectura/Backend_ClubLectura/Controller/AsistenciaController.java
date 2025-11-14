package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Asistencia;
import com.clublectura.Backend_ClubLectura.Service.IAsistenciaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/asistencia")

public class AsistenciaController {
    
    @Autowired
    private IAsistenciaService asistenciaService;

    @PostMapping("/insertar")
    public ResponseEntity<Asistencia> crearAsistencia(@Valid @RequestBody Asistencia asistencia) {
        return new ResponseEntity<>(asistenciaService.crear(asistencia), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Asistencia>> listarAsistencias() {
        return new ResponseEntity<>(asistenciaService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Asistencia> buscarAsistencia(@PathVariable Integer id) {
        return new ResponseEntity<>(asistenciaService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAsistencia(@PathVariable Integer id) {
        asistenciaService.eliminar(id);
        return new ResponseEntity<>("Asistencia eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Asistencia> actualizarAsistencia(@PathVariable Integer id,
                                                  @Valid @RequestBody Asistencia asistencia) {
        Asistencia actualizado = asistenciaService.actualizar(id, asistencia);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
