package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.RetoLectura;
import java.util.List;

public interface IRetoLecturaService {
    
    List<RetoLectura> listar();
    RetoLectura obtener(Integer id);
    RetoLectura crear(RetoLectura retoLectura);
    RetoLectura actualizar(Integer id, RetoLectura retoLectura);
    void eliminar(Integer id);
}
