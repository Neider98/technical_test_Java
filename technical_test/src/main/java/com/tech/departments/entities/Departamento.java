package com.tech.departments.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "codigo")
    private String codigo;
    @NotNull
    @Column(name = "departamento_nombre")
    private String nombre;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_crea")
    private LocalDateTime fechaHoraCrea;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_modifica")
    private LocalDateTime fechaHoraModifica;

    @PrePersist
    public void prePersist() {
        fechaHoraModifica = LocalDateTime.now();
        fechaHoraCrea = LocalDateTime.now();
    }

}
