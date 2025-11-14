package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.RetoLectura;

public interface IRetoLecturaRepository extends JpaRepository<RetoLectura, Integer> {
    
}
