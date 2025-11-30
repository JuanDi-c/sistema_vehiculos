package com.juan.proyecto_apis.service.implementacion;

import com.juan.proyecto_apis.entity.Conductor;
import com.juan.proyecto_apis.repository.ConductorRepository;
import com.juan.proyecto_apis.service.ConductorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ConductorImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public List<Conductor> listConductores() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @SneakyThrows
    @Override
    public Conductor updateConductor(Long idConductor, Conductor conductor) {
        Conductor conductorExisting = conductorRepository.findByidConductor(idConductor)
                .orElseThrow(()->new Exception("conductor con no encontrado"));

        conductorExisting.setNombreConductor(conductor.getNombreConductor());
        conductorExisting.setLicenciaConductor(conductor.getLicenciaConductor());
        conductorExisting.setTelefonoConductor(conductor.getTelefonoConductor());
        conductorExisting.setDireccionConductor(conductor.getDireccionConductor());
        conductorExisting.setConductorState(conductor.getConductorState());


        return conductorRepository.save(conductorExisting);
    }

    @SneakyThrows
    @Override
    public void deleteConductor(Long idConductor) {
        conductorRepository.findByidConductor(idConductor)
                .orElseThrow(()->new Exception("conductor con ID" + idConductor +"no encontrado"));

        conductorRepository.deleteById(idConductor);
    }
}
