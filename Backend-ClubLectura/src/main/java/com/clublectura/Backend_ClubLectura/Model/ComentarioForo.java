package com.clublectura.Backend_ClubLectura.Model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comentarioforo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ComentarioForo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    private LocalDate fechaPublicacion;

    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idForo")
    private Foro foro;

    private String comentarioPadre;
}
