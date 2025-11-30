package com.juan.proyecto_apis.repository;

import com.juan.proyecto_apis.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {

    Optional<Vehiculo> findByVehiculoId(Long vehiculoId);
}
