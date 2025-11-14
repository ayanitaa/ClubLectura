package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.ProgresoReto;
import java.util.List;

public interface IProgresoRetoService {
    
    List<ProgresoReto> listar();
    ProgresoReto obtener(Integer id);  
    ProgresoReto crear(ProgresoReto progresoReto);
    ProgresoReto actualizar(Integer id, ProgresoReto progresoReto);
    void eliminar(Integer id);
}
