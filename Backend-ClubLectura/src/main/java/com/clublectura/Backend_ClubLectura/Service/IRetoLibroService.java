package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.RetoLibro;

import java.util.List;

public interface IRetoLibroService {

    List<RetoLibro> listar();
    RetoLibro obtener(Integer idReto, Integer idLibro);
    RetoLibro crear(RetoLibro retoLibro);
    String eliminar(Integer idReto, Integer idLibro);

    List<RetoLibro> listarPorReto(Integer idReto);
    List<RetoLibro> listarPorLibro(Integer idLibro);
}
