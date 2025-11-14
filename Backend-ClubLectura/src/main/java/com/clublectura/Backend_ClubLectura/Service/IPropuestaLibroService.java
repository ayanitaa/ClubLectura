package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.PropuestaLibro;
import java.util.List;

public interface IPropuestaLibroService {
    
    List<PropuestaLibro> listar();
    PropuestaLibro obtener(Integer id);
    PropuestaLibro crear(PropuestaLibro propuestaLibro);
    PropuestaLibro actualizar(Integer id, PropuestaLibro propuestaLibro);
    void eliminar(Integer id);
}
