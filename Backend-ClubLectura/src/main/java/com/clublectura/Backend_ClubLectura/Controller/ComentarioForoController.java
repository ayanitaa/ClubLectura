package com.clublectura.Backend_ClubLectura.Controller;

import org.springframework.web.bind.annotation.*;
import com.clublectura.Backend_ClubLectura.Model.ComentarioForo;
import com.clublectura.Backend_ClubLectura.Service.IComentarioForoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/GCL/comentarioForo")

public class ComentarioForoController {

    @Autowired
    private IComentarioForoService comentarioForoService;

    @PostMapping("/insertar")
    public ResponseEntity<ComentarioForo> crearComentarioForo(@Valid @RequestBody ComentarioForo comentarioForo) {
        return new ResponseEntity<>(comentarioForoService.crear(comentarioForo), HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<ComentarioForo>> listarComentariosForo() {
        return new ResponseEntity<>(comentarioForoService.listar(), HttpStatus.OK);
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ComentarioForo> buscarComentarioForo(@PathVariable Integer id) {
        return new ResponseEntity<>(comentarioForoService.obtener(id), HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarComentarioForo(@PathVariable Integer id) {
        comentarioForoService.eliminar(id);
        return new ResponseEntity<>("Comentario de foro eliminado correctamente", HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ComentarioForo> actualizarComentarioForo(@PathVariable Integer id,
                                                  @Valid @RequestBody ComentarioForo comentarioForo) {
        ComentarioForo actualizado = comentarioForoService.actualizar(id, comentarioForo);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
