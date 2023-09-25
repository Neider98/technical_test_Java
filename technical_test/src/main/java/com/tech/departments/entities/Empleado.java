package com.tech.departments.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "documento_tipo")
    private String documentoTipo;
    @NotNull
    @Column(name = "documento_numero")
    private String documentoNumero;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    @NotNull
    private String ciudad;
    @NotNull
    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;
    @NotNull
    private String telefono;

    @Column(name = "fecha_hora_crea")
    private LocalDateTime fechaHoraCrea;

    @Column(name = "fecha_hora_modifica")
    private LocalDateTime fechaHoraModifica;

    @PrePersist
    public void prePersist() {
        fechaHoraModifica = LocalDateTime.now();
        fechaHoraCrea = LocalDateTime.now();
    }
}
