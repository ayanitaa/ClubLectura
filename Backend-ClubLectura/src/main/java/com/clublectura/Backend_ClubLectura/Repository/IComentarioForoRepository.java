package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.ComentarioForo;

public interface IComentarioForoRepository extends JpaRepository<ComentarioForo, Integer> {
    
}
