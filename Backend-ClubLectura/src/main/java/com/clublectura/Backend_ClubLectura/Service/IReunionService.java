package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Reunion;
import java.util.List;

public interface IReunionService {
    
    List<Reunion> listar();
    Reunion obtener(Integer id);
    Reunion crear(Reunion reunion);
    Reunion actualizar(Integer id, Reunion reunion);
    void eliminar(Integer id);
}
