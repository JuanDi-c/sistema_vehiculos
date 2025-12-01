package com.juan.proyecto_apis.repository;

import com.juan.proyecto_apis.entity.Seguro;
import com.juan.proyecto_apis.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeguroRepository extends JpaRepository<Seguro,String> {
    Optional<Seguro> findByidSeguro(String idConductor);

    List<Seguro> findByVehiculo(Vehiculo vehiculo);
}
