package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.ComentarioResena;
import java.util.List;

public interface IComentarioResenaService {
    
    List<ComentarioResena> listar();
    ComentarioResena obtener(Integer id);
    ComentarioResena crear(ComentarioResena comentarioResena);
    ComentarioResena actualizar(Integer id, ComentarioResena comentarioResena);
    void eliminar(Integer id);
}
