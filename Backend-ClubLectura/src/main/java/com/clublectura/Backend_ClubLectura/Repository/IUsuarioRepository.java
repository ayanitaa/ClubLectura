package com.clublectura.Backend_ClubLectura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clublectura.Backend_ClubLectura.Model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
