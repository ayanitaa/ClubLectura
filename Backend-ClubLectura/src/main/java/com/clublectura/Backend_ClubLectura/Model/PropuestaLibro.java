package com.clublectura.Backend_ClubLectura.Model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "propuestalibro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PropuestaLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropuesta;

    private LocalDate fechaPropuesta;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDate fechaDecision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private Libro libro;

    public enum Estado {
        seleccionado, rechazado
    }
}
