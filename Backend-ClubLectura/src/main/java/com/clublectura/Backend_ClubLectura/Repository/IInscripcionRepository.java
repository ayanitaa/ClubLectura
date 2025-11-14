package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Inscripcion;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    
}
