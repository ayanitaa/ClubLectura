package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.ProgresoReto;
import java.util.List;
import com.clublectura.Backend_ClubLectura.Repository.IProgresoRetoRepository;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import org .springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ProgresoRetoServiceImp implements IProgresoRetoService {
    
    @Autowired
    private IProgresoRetoRepository repo;

    @Override
    public List<ProgresoReto> listar() {
        return repo.findAll();
    }

    @Override
    public ProgresoReto obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Progreso de reto no encontrado"));
    }

    @Override
    public ProgresoReto crear(ProgresoReto progreso) {
        return repo.save(progreso);
    }

    @Override
    public ProgresoReto actualizar(Integer id, ProgresoReto progreso) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Progreso de reto no encontrado");
        }
        progreso.setIdProgreso(id);
        return repo.save(progreso);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Progreso de reto no encontrado");
        }
        repo.deleteById(id);
    }
}

