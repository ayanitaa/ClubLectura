package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.Asistencia;
import com.clublectura.Backend_ClubLectura.Repository.IAsistenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class AsistenciaServiceImp implements IAsistenciaService {
    
    @Autowired
    private IAsistenciaRepository repo;

    @Override
    public List<Asistencia> listar() {
        return repo.findAll();
    }

    @Override
    public Asistencia obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Asistencia no encontrada"));
    }

    @Override
    public Asistencia crear(Asistencia asistencia) {
        return repo.save(asistencia);
    }

    @Override
    public Asistencia actualizar(Integer id, Asistencia asistencia) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Asistencia no encontrada");
        }
        asistencia.setIdAsistencia(id);
        return repo.save(asistencia);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Asistencia no encontrada");
        }
        repo.deleteById(id);
    }
}
