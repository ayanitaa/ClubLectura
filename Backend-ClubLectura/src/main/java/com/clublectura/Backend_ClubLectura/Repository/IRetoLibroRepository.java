package com.clublectura.Backend_ClubLectura.Repository;

import com.clublectura.Backend_ClubLectura.Model.RetoLibro;
import com.clublectura.Backend_ClubLectura.Model.RetoLibroId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRetoLibroRepository extends JpaRepository<RetoLibro, RetoLibroId> {

    List<RetoLibro> findByRetoLectura_IdReto(Integer idReto);
    List<RetoLibro> findByLibro_IdLibro(Integer idLibro);

    boolean existsByRetoLectura_IdRetoAndLibro_IdLibro(Integer idReto, Integer idLibro);
    Optional<RetoLibro> findByRetoLectura_IdRetoAndLibro_IdLibro(Integer idReto, Integer idLibro);
}
