package com.clublectura.Backend_ClubLectura.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Inscripcion;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    
    boolean existsByUsuario_IdUsuarioAndRetoLectura_IdReto(Integer idUsuario, Integer idReto);

    Optional<Inscripcion> findByUsuario_IdUsuarioAndRetoLectura_IdReto(Integer idUsuario, Integer idReto);
}
