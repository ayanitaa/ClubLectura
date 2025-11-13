package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "archivoadjunto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ArchivoAdjunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArchivo;

    private String tipoArchivo;

    private String nombre;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idResena")
    private Resena resena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReunion")
    private Reunion reunion;
}