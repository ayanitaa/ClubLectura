package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Asistencia;

public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    
}
