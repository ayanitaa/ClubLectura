package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "progresoreto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProgresoReto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgreso;

    private Double porcentajeAvance;

    private LocalDate fechaActualizacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private RetoLectura retoLectura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idInscripcion")
    private Inscripcion inscripcion;

    public enum Estado {
        no_iniciado, en_progreso, completado
    }
}
