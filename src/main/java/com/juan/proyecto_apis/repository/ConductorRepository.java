package com.juan.proyecto_apis.repository;

import com.juan.proyecto_apis.entity.Conductor;
import com.juan.proyecto_apis.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ConductorRepository extends JpaRepository<Conductor,Long> {
    Optional<Conductor> findByidConductor(Long idConductor);
}
