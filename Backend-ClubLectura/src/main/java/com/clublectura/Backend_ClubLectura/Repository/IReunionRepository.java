package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Reunion;

public interface IReunionRepository extends JpaRepository<Reunion, Integer> {
    
}
