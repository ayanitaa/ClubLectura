package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "votacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Votacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVotacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idLibro")
    private Libro libro;

    private LocalDate fecha;

    private Boolean voto;
}
