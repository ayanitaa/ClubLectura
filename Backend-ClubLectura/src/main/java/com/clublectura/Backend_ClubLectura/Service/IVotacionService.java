package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Votacion;
import java.util.List;

public interface IVotacionService {
    
    List<Votacion> listar();
    Votacion obtener(Integer id);
    Votacion crear(Votacion votacion);
    Votacion actualizar(Integer id, Votacion votacion);
    void eliminar(Integer id);
}
