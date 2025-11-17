package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Exception.ReglasClubException;
import com.clublectura.Backend_ClubLectura.Model.RetoLibro;
import com.clublectura.Backend_ClubLectura.Model.RetoLibroId;
import com.clublectura.Backend_ClubLectura.Repository.IRetoLibroRepository;
import com.clublectura.Backend_ClubLectura.Repository.IRetoLecturaRepository;
import com.clublectura.Backend_ClubLectura.Repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RetoLibroServiceImp implements IRetoLibroService {

    @Autowired
    private IRetoLibroRepository repo;

    @Autowired
    private IRetoLecturaRepository retoRepo;

    @Autowired
    private ILibroRepository libroRepo;

    @Override
    public List<RetoLibro> listar() {
        return repo.findAll();
    }

    @Override
    public RetoLibro obtener(Integer idReto, Integer idLibro) {
        RetoLibroId id = new RetoLibroId(idReto, idLibro);
        return repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Relación Reto-Libro no encontrada"));
    }

    @Override
    public RetoLibro crear(RetoLibro retoLibro) {

        if (retoLibro.getRetoLectura() == null || retoLibro.getRetoLectura().getIdReto() == null) {
            throw new ReglasClubException("Debe especificar el reto de lectura.");
        }
        if (retoLibro.getLibro() == null || retoLibro.getLibro().getIdLibro() == null) {
            throw new ReglasClubException("Debe especificar el libro.");
        }

        Integer idReto = retoLibro.getRetoLectura().getIdReto();
        Integer idLibro = retoLibro.getLibro().getIdLibro();

        // validar existencia de reto y libro
        if (!retoRepo.existsById(idReto)) {
            throw new ReglasClubException("El reto con ID " + idReto + " no existe.");
        }
        if (!libroRepo.existsById(idLibro)) {
            throw new ReglasClubException("El libro con ID " + idLibro + " no existe.");
        }

        // evitar duplicado
        if (repo.existsByRetoLectura_IdRetoAndLibro_IdLibro(idReto, idLibro)) {
            throw new ReglasClubException("Este libro ya está asociado a ese reto.");
        }

        // setear ID compuesto
        retoLibro.setId(new RetoLibroId(idReto, idLibro));

        return repo.save(retoLibro);
    }

    @Override
    public String eliminar(Integer idReto, Integer idLibro) {

        RetoLibroId id = new RetoLibroId(idReto, idLibro);

        RetoLibro existente = repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Relación Reto-Libro no encontrada"));

        repo.delete(existente);
        return "Relación Reto-Libro eliminada correctamente";
    }

    @Override
    public List<RetoLibro> listarPorReto(Integer idReto) {
        return repo.findByRetoLectura_IdReto(idReto);
    }

    @Override
    public List<RetoLibro> listarPorLibro(Integer idLibro) {
        return repo.findByLibro_IdLibro(idLibro);
    }
}
