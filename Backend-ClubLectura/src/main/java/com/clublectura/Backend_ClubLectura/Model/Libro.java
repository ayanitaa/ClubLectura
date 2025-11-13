package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "libro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Libro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;

    @NotBlank @Column(nullable = false, length = 150)
    private String titulo;

    @Column(length = 100)
    private String autor;

    @Column(length = 50)
    private String genero;

    private Integer anioPublicacion;

    @Lob
    private String sinopsis;

    @Column(length = 200)
    private String portada;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EstadoLectura estadoLectura = EstadoLectura.pendiente;

    private LocalDate fechaSeleccion;

    public enum EstadoLectura { pendiente, en_lectura, leido }
}
