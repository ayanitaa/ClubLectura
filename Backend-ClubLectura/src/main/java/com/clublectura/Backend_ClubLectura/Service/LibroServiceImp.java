package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Libro;
import java.util.List;
import com.clublectura.Backend_ClubLectura.Repository.ILibroRepository;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import org .springframework.stereotype.Service;

@Service

public class LibroServiceImp implements ILibroService {
    private final ILibroRepository repo;

    public LibroServiceImp(ILibroRepository repo) { this.repo = repo; }

    @Override
    public List<Libro> listar() { return repo.findAll(); }

    @Override
    public Libro obtener(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new RecursoNoEncontradoException("Libro no encontrado"));
    }

    @Override
    public Libro crear(Libro l) { return repo.save(l); }

    @Override
    public Libro actualizar(Integer id, Libro l) {
        Libro db = obtener(id);
        db.setTitulo(l.getTitulo());
        db.setAutor(l.getAutor());
        db.setGenero(l.getGenero());
        db.setAnioPublicacion(l.getAnioPublicacion());
        db.setSinopsis(l.getSinopsis());
        db.setPortada(l.getPortada());
        db.setEstadoLectura(l.getEstadoLectura());
        db.setFechaSeleccion(l.getFechaSeleccion());
        return repo.save(db);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) throw new RecursoNoEncontradoException("Libro no encontrado");
        repo.deleteById(id);
    }
}
