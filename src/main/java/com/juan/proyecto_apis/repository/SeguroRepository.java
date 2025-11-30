package com.juan.proyecto_apis.repository;

import com.juan.proyecto_apis.entity.Conductor;
import com.juan.proyecto_apis.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeguroRepository extends JpaRepository<Seguro,String> {
    Optional<Seguro> findByidSeguro(String idConductor);
}
