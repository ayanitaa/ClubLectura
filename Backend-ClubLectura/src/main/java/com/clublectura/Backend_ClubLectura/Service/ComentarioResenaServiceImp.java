package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.ComentarioResena;
import com.clublectura.Backend_ClubLectura.Repository.IComentarioResenaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ComentarioResenaServiceImp implements IComentarioResenaService {
    
    @Autowired
    private IComentarioResenaRepository repo;

    @Override
    public List<ComentarioResena> listar() {
        return repo.findAll();
    }

    @Override
    public ComentarioResena obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Comentario de reseña no encontrado"));
    }

    @Override
    public ComentarioResena crear(ComentarioResena comentario) {
        return repo.save(comentario);
    }

    @Override
    public ComentarioResena actualizar(Integer id, ComentarioResena comentario) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Comentario de reseña no encontrado");
        }
        comentario.setIdComentario(id);
        return repo.save(comentario);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Comentario de reseña no encontrado");
        }
        repo.deleteById(id);
    }
}

