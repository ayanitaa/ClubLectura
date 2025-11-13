package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {
    
}
