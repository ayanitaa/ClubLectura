package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Foro;
import java.util.List;

public interface IForoService {
    
    List<Foro> listar();
    Foro obtener(Integer id);
    Foro crear(Foro foro);
    Foro actualizar(Integer id, Foro foro);
    void eliminar(Integer id);
}