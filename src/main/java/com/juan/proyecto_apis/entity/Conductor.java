package com.juan.proyecto_apis.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conductor_id")
    private Long idConductor;

    @Column(name = "conductor_nombre")
    private String nombreConductor;

    @Column(name = "conductor_licencia")
    private String licenciaConductor;

    @Column(name = "conductor_telefono")
    private String telefonoConductor;

    @Column(name = "conductor_direccion")
    private String direccionConductor;

    @Enumerated(EnumType.STRING)
    @Column(name= "disp_conductor", nullable = false)
    private ConductorState conductorState;

}
