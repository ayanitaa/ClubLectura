package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Foro;
import com.clublectura.Backend_ClubLectura.Repository.IForoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ForoServiceImp implements IForoService {
    
    @Autowired
    private IForoRepository repo;
    
    @Override
    public List<Foro> listar() {
        return repo.findAll();
    } 

    @Override
    public Foro obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Foro no encontrado"));
    }

    @Override
    public Foro crear(Foro foro) {
        return repo.save(foro);
    }

    @Override
    public Foro actualizar(Integer id, Foro foro) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Foro no encontrado");
        }
        foro.setIdForo(id);
        return repo.save(foro);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Foro no encontrado");
        }
        repo.deleteById(id);
    }

}
