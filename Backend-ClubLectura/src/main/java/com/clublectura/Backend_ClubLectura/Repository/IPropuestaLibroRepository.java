package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.PropuestaLibro;

public interface IPropuestaLibroRepository extends JpaRepository<PropuestaLibro, Integer> {
    
}
