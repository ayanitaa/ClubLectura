package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.ArchivoAdjunto;
import com.clublectura.Backend_ClubLectura.Service.IArchivoAdjuntoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/archivoAdjunto")

public class ArchivoAdjuntoController {
    
    @Autowired
    private IArchivoAdjuntoService archivoAdjuntoService;

    @PostMapping("/insertar")
    public ResponseEntity<ArchivoAdjunto> crearArchivoAdjunto(@Valid @RequestBody ArchivoAdjunto archivoAdjunto) {
        return new ResponseEntity<>(archivoAdjuntoService.crear(archivoAdjunto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ArchivoAdjunto>> listarArchivosAdjuntos() {
        return new ResponseEntity<>(archivoAdjuntoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ArchivoAdjunto> buscarArchivoAdjunto(@PathVariable Integer id) {
        return new ResponseEntity<>(archivoAdjuntoService.obtener(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarArchivoAdjunto(@PathVariable Integer id) {
        archivoAdjuntoService.eliminar(id);
        return new ResponseEntity<>("Archivo adjunto eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ArchivoAdjunto> actualizarArchivoAdjunto(@PathVariable Integer id,
                                                  @Valid @RequestBody ArchivoAdjunto archivoAdjunto) {
        ArchivoAdjunto actualizado = archivoAdjuntoService.actualizar(id, archivoAdjunto);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
