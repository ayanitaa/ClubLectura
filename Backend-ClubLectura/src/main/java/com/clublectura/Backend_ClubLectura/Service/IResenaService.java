package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Resena;
import java.util.List;

public interface IResenaService {
    
    List<Resena> listar();
    Resena obtener(Integer id);
    Resena crear(Resena resena);
    Resena actualizar(Integer id, Resena resena);
    void eliminar(Integer id);

    List<Resena> listarPorLibro(Integer libroId);
    List<Resena> listarPorUsuario(Integer usuarioId);
}
