package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Asistencia;
import java.util.List;

public interface IAsistenciaService {
    
    List<Asistencia> listar();
    Asistencia obtener(Integer id);
    Asistencia crear(Asistencia asistencia);
    Asistencia actualizar(Integer id, Asistencia asistencia);
    void eliminar(Integer id);
}
