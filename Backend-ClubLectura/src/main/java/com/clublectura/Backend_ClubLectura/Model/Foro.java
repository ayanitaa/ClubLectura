package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "foro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Foro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idForo;

    private LocalDate fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idModerador")
    private Usuario moderador;

    public enum Categoria { genero, autor, tema }
}
