package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.RetoLectura;
import java.util.List;
import org.springframework.stereotype.Service;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Repository.IRetoLecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class RetoLecturaImp implements IRetoLecturaService {
    
    @Autowired
    private IRetoLecturaRepository repo;

    @Override
    public List<RetoLectura> listar() {
        return repo.findAll();
    }

    @Override
    public RetoLectura obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reto de lectura no encontrado"));
    }

    @Override
    public RetoLectura crear(RetoLectura reto) {
        return repo.save(reto);
    }

    @Override
    public RetoLectura actualizar(Integer id, RetoLectura reto) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Reto de lectura no encontrado");
        }
        reto.setIdReto(id);
        return repo.save(reto);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Reto de lectura no encontrado");
        }
        repo.deleteById(id);
    }
}

