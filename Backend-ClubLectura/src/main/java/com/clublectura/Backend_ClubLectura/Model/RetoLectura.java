package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "retolectura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RetoLectura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReto;

    private String titulo;

    private String descripcion;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
