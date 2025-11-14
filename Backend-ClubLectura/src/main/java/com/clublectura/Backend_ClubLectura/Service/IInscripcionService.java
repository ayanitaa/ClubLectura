package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Inscripcion;
import java.util.List;

public interface IInscripcionService {
    
    List<Inscripcion> listar();
    Inscripcion obtener(Integer id);
    Inscripcion crear(Inscripcion inscripcion);
    Inscripcion actualizar(Integer id, Inscripcion inscripcion);
    String eliminar(Integer id);
}
