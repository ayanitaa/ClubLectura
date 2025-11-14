package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.ComentarioForo;
import com.clublectura.Backend_ClubLectura.Repository.IComentarioForoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ComentarioForoServiceImp implements IComentarioForoService {
    
    @Autowired
    private IComentarioForoRepository repo;

    @Override
    public List<ComentarioForo> listar() {
        return repo.findAll();
    }

    @Override
    public ComentarioForo obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Comentario de foro no encontrado"));
    }

    @Override
    public ComentarioForo crear(ComentarioForo comentarioForo) {
        return repo.save(comentarioForo);
    }

    @Override
    public ComentarioForo actualizar(Integer id, ComentarioForo comentarioForo) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Comentario de foro no encontrado");
        }
        comentarioForo.setIdComentario(id);
        return repo.save(comentarioForo);
    }
    
    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Comentario de foro no encontrado");
        }
        repo.deleteById(id);
    }
}
