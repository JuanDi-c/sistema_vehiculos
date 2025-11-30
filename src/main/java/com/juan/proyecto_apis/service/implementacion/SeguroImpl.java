package com.juan.proyecto_apis.service.implementacion;

import com.juan.proyecto_apis.entity.Seguro;
import com.juan.proyecto_apis.repository.SeguroRepository;
import com.juan.proyecto_apis.service.SeguroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SeguroImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;


    @Override
    public List<Seguro> listSeguros() {
        return seguroRepository.findAll();
    }

    @Override
    public Seguro registerSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @SneakyThrows
    @Override
    public Seguro updateSeguro(String idSeguro, Seguro seguro) {
        Seguro seguroExisting = seguroRepository.findByidSeguro(idSeguro)
                .orElseThrow(() -> new Exception("Seguro no encontrado"));

        seguroExisting.setCompSeguro(seguro.getCompSeguro());
        seguroExisting.setPolSeguro(seguro.getPolSeguro());
        seguroExisting.setFiniSeguro(seguro.getFiniSeguro());
        seguroExisting.setFvenSeguro(seguro.getFvenSeguro());

        return seguroRepository.save(seguroExisting);

    }

    @SneakyThrows
    @Override
    public void deleteSeguro(String idSeguro) {
        seguroRepository.findByidSeguro(idSeguro)
                .orElseThrow(()-> new Exception("Seguro no encontrado"));

        seguroRepository.deleteById(idSeguro);
    }
}

