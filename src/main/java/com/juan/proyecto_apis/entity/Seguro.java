package com.juan.proyecto_apis.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seguro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seguro_id")
    private Long idSeguro;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "vehiculo_id",nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "seguro_compañia")
    private String compSeguro;

    @Column(name = "seguro_poliza")
    private String polSeguro;

    @Column(name = "seguro_fechaini")
    private String finiSeguro;

    @Column(name = "seguro_fechaven")
    private String fvenSeguro;
}
