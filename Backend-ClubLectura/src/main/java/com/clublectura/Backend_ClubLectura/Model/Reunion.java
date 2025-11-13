package com.clublectura.Backend_ClubLectura.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reunion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Reunion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReunion;

    private LocalDate fecha;

    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    private Modalidad modalidad;

    private String lugar_o_enlace;

    public enum Modalidad {
        presencial, virtual
    }
}
