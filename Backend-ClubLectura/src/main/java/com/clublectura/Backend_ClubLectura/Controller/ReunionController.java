package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Reunion;
import com.clublectura.Backend_ClubLectura.Service.IReunionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/reunion")

public class ReunionController {
    
    @Autowired
    private IReunionService reunionService;
    
    @PostMapping("/insertar")
    public ResponseEntity<Reunion> crearReunion(@Valid @RequestBody Reunion reunion) {
        return new ResponseEntity<>(reunionService.crear(reunion), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Reunion>> listarReuniones() {
        return new ResponseEntity<>(reunionService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Reunion> buscarReunion(@PathVariable Integer id) {
        return new ResponseEntity<>(reunionService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarReunion(@PathVariable Integer id) {
        reunionService.eliminar(id);
        return new ResponseEntity<>("Reunión eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Reunion> actualizarReunion(@PathVariable Integer id,
                                                  @Valid @RequestBody Reunion reunion) {
        Reunion actualizado = reunionService.actualizar(id, reunion);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

}
