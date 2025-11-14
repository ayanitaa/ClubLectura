package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Foro;

public interface IForoRepository extends JpaRepository<Foro, Integer> {
    
}
