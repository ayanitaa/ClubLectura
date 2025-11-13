package com.clublectura.Backend_ClubLectura.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuario") 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nombreCompleto;

    @Min(0)
    private Integer edad;

    @Column(length = 50)
    private String ocupacion;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(length = 15)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RolUsuario rol = RolUsuario.LECTOR;

    public enum RolUsuario { LECTOR, MODERADOR, ADMINISTRADOR }
}
