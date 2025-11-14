package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.PropuestaLibro;
import com.clublectura.Backend_ClubLectura.Repository.IPropuestaLibroRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class PropuestaLibroServiceImp implements IPropuestaLibroService {
    
    @Autowired
    private IPropuestaLibroRepository repo;

    @Override
    public List<PropuestaLibro> listar() {
        return repo.findAll();
    }

    @Override
    public PropuestaLibro obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Propuesta de libro no encontrada"));
    }

    @Override
    public PropuestaLibro crear(PropuestaLibro propuesta) {
        return repo.save(propuesta);
    }

    @Override
    public PropuestaLibro actualizar(Integer id, PropuestaLibro propuesta) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Propuesta de libro no encontrada");
        }
        propuesta.setIdPropuesta(id);
        return repo.save(propuesta);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Propuesta de libro no encontrada");
        }
        repo.deleteById(id);
    }
}
