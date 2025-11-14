package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.ArchivoAdjunto;
import java.util.List;

public interface IArchivoAdjuntoService {
    
    ArchivoAdjunto crear(ArchivoAdjunto archivoAdjunto);
    List<ArchivoAdjunto> listar();
    ArchivoAdjunto obtener(Integer id);
    ArchivoAdjunto actualizar(Integer id, ArchivoAdjunto archivoAdjunto);
    void eliminar(Integer id);
}
