package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Libro;
import java.util.List;
import com.clublectura.Backend_ClubLectura.Repository.ILibroRepository;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import org .springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service

public class LibroServiceImp implements ILibroService {

    @Autowired
    private ILibroRepository repo;

    @Override
    public List<Libro> listar() {
        return repo.findAll();
    }

    @Override
    public Libro obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Libro no encontrado"));
    }

    @Override
    public Libro crear(Libro libro) {
        return repo.save(libro);
    }

    @Override
    public Libro actualizar(Integer id, Libro libro) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Libro no encontrado");
        }
        libro.setIdLibro(id);
        return repo.save(libro);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Libro no encontrado");
        }
        repo.deleteById(id);
    }
}


