package com.clublectura.Backend_ClubLectura.Service;

import java.util.List;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import com.clublectura.Backend_ClubLectura.Model.ArchivoAdjunto;
import com.clublectura.Backend_ClubLectura.Repository.IArchivoAdjuntoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service

public class ArchivoAdjuntoServiceImp implements IArchivoAdjuntoService {

    @Autowired
    private IArchivoAdjuntoRepository repo;

    @Override
    public List<ArchivoAdjunto> listar() {
        return repo.findAll();
    }

    @Override
    public ArchivoAdjunto obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Archivo adjunto no encontrado"));
    }

    @Override
    public ArchivoAdjunto crear(ArchivoAdjunto archivoAdjunto) {
        return repo.save(archivoAdjunto);
    }

    @Override
    public ArchivoAdjunto actualizar(Integer id, ArchivoAdjunto archivoAdjunto) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Archivo adjunto no encontrado");
        }
        archivoAdjunto.setIdArchivo(id);
        return repo.save(archivoAdjunto);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontradoException("Archivo adjunto no encontrado");
        }
        repo.deleteById(id);
    }
}
