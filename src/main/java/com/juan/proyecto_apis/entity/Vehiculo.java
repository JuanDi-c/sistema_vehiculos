package com.juan.proyecto_apis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculo_id")
    private Long vehiculoId;

    @Column(name = "vehiculo_placa",nullable = false,length = 100)
    private String vehiculoPlaca;

    @Column(name = "vehiculo_marca",nullable = false)
    private String vehiculoMarca;

    @Column(name = "vehiculo_modelo",nullable = false)
    private String vehiculoModelo;

    @Column(name = "vehiculo_ano",nullable = false)
    private Integer vehiculoAno;

    @Column(name = "vehiculo_color",nullable = false)
    private String vehiculoColor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "conductor_id", referencedColumnName = "conductor_id",nullable = false)
    private Conductor conductor;

}
