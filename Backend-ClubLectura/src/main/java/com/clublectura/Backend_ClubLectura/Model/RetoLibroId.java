package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetoLibroId implements Serializable {

    private Integer idReto;
    private Integer idLibro;
}
