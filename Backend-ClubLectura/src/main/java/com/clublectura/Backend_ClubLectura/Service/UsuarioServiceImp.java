package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Usuario;
import com.clublectura.Backend_ClubLectura.Exception.RecursoNoEncontradoException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.clublectura.Backend_ClubLectura.Repository.IUsuarioRepository;

@Service

public class UsuarioServiceImp implements IUsuarioService {

    private final IUsuarioRepository repo;

    public UsuarioServiceImp(IUsuarioRepository repo) {
        this.repo = repo;
    }
    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @Override
    public Usuario obtener(Integer id) {
        return repo.findById(id).orElseThrow(() ->
                new RecursoNoEncontradoException("Usuario no encontrado"));
    }

    @Override
    public Usuario crear(Usuario u) {
        return repo.save(u);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario u) {
        Usuario db = obtener(id);
        // copiamos campos editables
        db.setNombreCompleto(u.getNombreCompleto());
        db.setEdad(u.getEdad());
        db.setOcupacion(u.getOcupacion());
        db.setCorreoElectronico(u.getCorreoElectronico());
        db.setTelefono(u.getTelefono());
        db.setRol(u.getRol());
        return repo.save(db);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repo.existsById(id)) throw new RecursoNoEncontradoException("Usuario no encontrado");
        repo.deleteById(id);
    }
}
