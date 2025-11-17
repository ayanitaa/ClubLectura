package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "retolibro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetoLibro {

    @EmbeddedId
    private RetoLibroId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idReto")
    @JoinColumn(name = "idReto", nullable = false)
    private RetoLectura retoLectura;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idLibro")
    @JoinColumn(name = "idLibro", nullable = false)
    private Libro libro;
}
