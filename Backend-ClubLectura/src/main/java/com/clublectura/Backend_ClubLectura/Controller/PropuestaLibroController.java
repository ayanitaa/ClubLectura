package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.PropuestaLibro;
import com.clublectura.Backend_ClubLectura.Service.IPropuestaLibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/propuestaLibro")

public class PropuestaLibroController {

    @Autowired
    private IPropuestaLibroService service;

    @PostMapping("/insertar")
    public ResponseEntity<PropuestaLibro> crearPropuesta(@Valid @RequestBody PropuestaLibro propuesta) {
        return new ResponseEntity<>(service.crear(propuesta), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PropuestaLibro>> listarPropuestas() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PropuestaLibro> buscarPropuesta(@PathVariable Integer id) {
        return new ResponseEntity<>(service.obtener(id), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PropuestaLibro> actualizarPropuesta(@PathVariable Integer id,
                                                                   @Valid @RequestBody PropuestaLibro propuesta) {
        return new ResponseEntity<>(service.actualizar(id, propuesta), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPropuesta(@PathVariable Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>("Propuesta eliminada correctamente", HttpStatus.OK);
    }

}
