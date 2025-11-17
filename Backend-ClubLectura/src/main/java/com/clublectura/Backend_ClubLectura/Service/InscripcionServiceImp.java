package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Exception.ReglasClubException;
import com.clublectura.Backend_ClubLectura.Model.Inscripcion;
import com.clublectura.Backend_ClubLectura.Repository.IInscripcionRepository;
import com.clublectura.Backend_ClubLectura.Repository.IUsuarioRepository;
import com.clublectura.Backend_ClubLectura.Repository.IRetoLecturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServiceImp implements IInscripcionService {

    @Autowired
    private IInscripcionRepository repo;

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Autowired
    private IRetoLecturaRepository retoRepo;

    @Override
    public List<Inscripcion> listar() {
        return repo.findAll();
    }

    @Override
    public Inscripcion obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Inscripción no encontrada"));
    }

    @Override
    public Inscripcion crear(Inscripcion inscripcion) {

        
        if (inscripcion.getUsuario() == null || inscripcion.getUsuario().getIdUsuario() == null) {
            throw new ReglasClubException("Debe especificar el usuario para la inscripción.");
        }
        if (inscripcion.getRetoLectura() == null || inscripcion.getRetoLectura().getIdReto() == null) {
            throw new ReglasClubException("Debe especificar el reto de lectura para la inscripción.");
        }

        Integer idUsuario = inscripcion.getUsuario().getIdUsuario();
        Integer idReto = inscripcion.getRetoLectura().getIdReto();

        if (!usuarioRepo.existsById(idUsuario)) {
            throw new ReglasClubException("El usuario con ID " + idUsuario + " no existe.");
        }

        if (!retoRepo.existsById(idReto)) {
            throw new ReglasClubException("El reto con ID " + idReto + " no existe.");
        }

        if (repo.existsByUsuario_IdUsuarioAndRetoLectura_IdReto(idUsuario, idReto)) {
            throw new ReglasClubException("El usuario ya está inscrito en este reto.");
        }

        return repo.save(inscripcion);
    }

    @Override
    public Inscripcion actualizar(Integer id, Inscripcion inscripcion) {

        
        Inscripcion existente = repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Inscripción no encontrada"));

        if (inscripcion.getUsuario() == null || inscripcion.getUsuario().getIdUsuario() == null) {
            throw new ReglasClubException("Debe especificar el usuario para la inscripción.");
        }
        if (inscripcion.getRetoLectura() == null || inscripcion.getRetoLectura().getIdReto() == null) {
            throw new ReglasClubException("Debe especificar el reto de lectura para la inscripción.");
        }

        Integer idUsuario = inscripcion.getUsuario().getIdUsuario();
        Integer idReto = inscripcion.getRetoLectura().getIdReto();

        if (!usuarioRepo.existsById(idUsuario)) {
            throw new ReglasClubException("El usuario con ID " + idUsuario + " no existe.");
        }

        if (!retoRepo.existsById(idReto)) {
            throw new ReglasClubException("El reto con ID " + idReto + " no existe.");
        }

        Optional<Inscripcion> otra = repo.findByUsuario_IdUsuarioAndRetoLectura_IdReto(idUsuario, idReto);
        if (otra.isPresent() && !otra.get().getIdInscripcion().equals(id)) {
            throw new ReglasClubException("El usuario ya está inscrito en este reto.");
        }

        
        inscripcion.setIdInscripcion(id);
        return repo.save(inscripcion);
    }

    @Override
    public String cancelar(Integer id) {
        Inscripcion inscripcion = repo.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException("Inscripción no encontrada"));

        inscripcion.setEstadoInscripcion(Inscripcion.EstadoInscripcion.cancelada);
        repo.save(inscripcion);

        return "Inscripción cancelada correctamente";
    }
}
