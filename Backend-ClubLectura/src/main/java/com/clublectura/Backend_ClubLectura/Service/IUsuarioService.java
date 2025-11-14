package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    List<Usuario> listar();
    Usuario obtener(Integer id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
}
