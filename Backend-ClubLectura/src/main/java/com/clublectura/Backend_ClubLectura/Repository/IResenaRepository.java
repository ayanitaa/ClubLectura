package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Resena;
import java.util.List;

public interface IResenaRepository extends JpaRepository<Resena, Integer> {
    
    List<Resena> findByLibro_IdLibro(Integer idLibro);
    List<Resena> findByUsuario_IdUsuario(Integer idUsuario);
}
