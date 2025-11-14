package com.clublectura.Backend_ClubLectura.Model;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "resena")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResena;

    @NotNull
    private LocalDate fecha;

    @Column(length = 250)
    private String opinion;

    @Min(1) @Max(5)
    private Integer calificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private Libro libro;
}
