package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.ComentarioResena;

public interface IComentarioResenaRepository extends JpaRepository<ComentarioResena, Integer> {
    
}
