package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Reunion;
import com.clublectura.Backend_ClubLectura.Repository.IReunionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ReunionServiceImp implements IReunionService {
    
    @Autowired
    private IReunionRepository repo;

    @Override
    public List<Reunion> listar() {
        return repo.findAll();
    }

    @Override
    public Reunion obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reunión no encontrada"));
    }

    @Override
    public Reunion crear(Reunion reunion) {
        return repo.save(reunion);
    }

    @Override
    public Reunion actualizar(Integer id, Reunion reunion) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Reunión no encontrada");
        }
        reunion.setIdReunion(id);
        return repo.save(reunion);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Reunión no encontrada");
        }
        repo.deleteById(id);
    }
}
