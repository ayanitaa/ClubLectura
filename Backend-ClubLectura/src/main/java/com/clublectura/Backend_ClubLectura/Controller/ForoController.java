package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.Foro;
import com.clublectura.Backend_ClubLectura.Service.IForoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/GCL/foro")

public class ForoController {
    
    @Autowired
    private IForoService foroService;

    @PostMapping("/insertar")
    public ResponseEntity<Foro> crearForo(@Valid @RequestBody Foro foro) {
        return new ResponseEntity<>(foroService.crear(foro), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Foro>> listarForos() {
        return new ResponseEntity<>(foroService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Foro> buscarForo(@PathVariable Integer id) {
        return new ResponseEntity<>(foroService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarForo(@PathVariable Integer id) {
        foroService.eliminar(id);
        return new ResponseEntity<>("Foro eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Foro> actualizarForo(@PathVariable Integer id,
                                                  @Valid @RequestBody Foro foro) {
        Foro actualizado = foroService.actualizar(id, foro);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
