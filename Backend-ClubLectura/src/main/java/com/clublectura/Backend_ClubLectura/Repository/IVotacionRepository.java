package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Votacion;

public interface IVotacionRepository extends JpaRepository<Votacion, Integer> {
    
}
