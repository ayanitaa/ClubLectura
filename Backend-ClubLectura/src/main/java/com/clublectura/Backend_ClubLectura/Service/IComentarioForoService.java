package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.ComentarioForo;
import java.util.List;

public interface IComentarioForoService {
    
    List<ComentarioForo> listar();
    ComentarioForo obtener(Integer id);
    ComentarioForo crear(ComentarioForo comentarioForo);
    ComentarioForo actualizar(Integer id, ComentarioForo comentarioForo);
    void eliminar(Integer id);
}
