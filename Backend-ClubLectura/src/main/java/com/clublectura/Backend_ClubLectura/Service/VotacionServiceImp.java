package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Votacion;
import com.clublectura.Backend_ClubLectura.Repository.IVotacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class VotacionServiceImp implements IVotacionService {
    
    @Autowired
    private IVotacionRepository repo;

    @Override
    public List<Votacion> listar() {
        return repo.findAll();
    }

    @Override
    public Votacion obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Votación no encontrada"));
    }

    @Override
    public Votacion crear(Votacion votacion) {
        return repo.save(votacion);
    }

    @Override
    public Votacion actualizar(Integer id, Votacion votacion) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Votación no encontrada");
        }
        votacion.setIdVotacion(id);
        return repo.save(votacion);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Votación no encontrada");
        }
        repo.deleteById(id);
    }
}
