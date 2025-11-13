package com.clublectura.Backend_ClubLectura.Model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comentarioresena")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ComentarioResena {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;

    private LocalDate fechaPublicacion;

    private String contenido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idResena")
    private Resena resena;
}
