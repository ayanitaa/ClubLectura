package com.clublectura.Backend_ClubLectura.Service;

import com.clublectura.Backend_ClubLectura.Model.Libro;
import java.util.List;

public interface ILibroService {
    List<Libro> listar();
    Libro obtener(Integer id);
    Libro crear(Libro libro);
    Libro actualizar(Integer id, Libro libro);
    void eliminar(Integer id);
}
