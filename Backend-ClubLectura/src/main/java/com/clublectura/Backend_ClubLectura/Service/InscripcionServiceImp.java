package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Inscripcion;
import com.clublectura.Backend_ClubLectura.Repository.IInscripcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class InscripcionServiceImp implements IInscripcionService {

    @Autowired
    private IInscripcionRepository repo;

    @Override
    public List<Inscripcion> listar() {
        return repo.findAll();
    }

    @Override
    public Inscripcion obtener(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new RecursoNoEncontradoException("Inscripción no encontrada"));
    }

    @Override
    public Inscripcion crear(Inscripcion inscripcion) {
        return repo.save(inscripcion);
    }
    
    @Override
    public Inscripcion actualizar(Integer id, Inscripcion inscripcion) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Inscripción no encontrada");
        }
        inscripcion.setIdInscripcion(id);
        return repo.save(inscripcion);
    }

    @Override
    public String eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Inscripción no encontrada");
        }
        repo.deleteById(id);
        return "Inscripción eliminada correctamente";
    }
}
