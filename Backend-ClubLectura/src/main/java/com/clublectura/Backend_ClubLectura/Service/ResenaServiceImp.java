package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Resena;
import com.clublectura.Backend_ClubLectura.Repository.IResenaRepository;
import org.springframework.stereotype.Service;

@Service

public class ResenaServiceImp implements IResenaService {
private final IResenaRepository repo;

    public ResenaServiceImp(IResenaRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<Resena> listar() { return repo.findAll(); }

    @Override
    public Resena obtener(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new RecursoNoEncontradoException("Reseña no encontrada"));
    }

    @Override
    public Resena crear(Resena r) { return repo.save(r); }

    @Override
    public Resena actualizar(Integer id, Resena r) {
        Resena db = obtener(id);
        db.setFecha(r.getFecha());
        db.setOpinion(r.getOpinion());
        db.setCalificacion(r.getCalificacion());
        db.setUsuario(r.getUsuario()); 
        db.setLibro(r.getLibro());     
        return repo.save(db);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) throw new RecursoNoEncontradoException("Reseña no encontrada");
        repo.deleteById(id);
    }

    @Override
    public List<Resena> listarPorLibro(Integer idLibro) {
        return repo.findByLibro_IdLibro(idLibro);
    }

    @Override
    public List<Resena> listarPorUsuario(Integer idUsuario) {
        return repo.findByUsuario_IdUsuario(idUsuario);
    }
    
}
