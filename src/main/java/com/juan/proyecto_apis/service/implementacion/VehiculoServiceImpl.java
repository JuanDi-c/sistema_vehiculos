package com.juan.proyecto_apis.service.implementacion;

import com.juan.proyecto_apis.entity.Vehiculo;
import com.juan.proyecto_apis.repository.VehiculoRepository;
import com.juan.proyecto_apis.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> ListVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @SneakyThrows
    @Override
    public Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByVehiculoId(vehiculoId)
                .orElseThrow(()->new Exception("vehiculo con ID" +vehiculoId+"no encontrado"));

                vehiculoExisting.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
                vehiculoExisting.setVehiculoMarca(vehiculo.getVehiculoMarca());
                vehiculoExisting.setVehiculoModelo(vehiculo.getVehiculoModelo());
                vehiculoExisting.setVehiculoAno(vehiculo.getVehiculoAno());
                vehiculoExisting.setVehiculoColor(vehiculo.getVehiculoColor());

                return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void deleteVehiculo(Long vehiculoId) {
        vehiculoRepository.findByVehiculoId(vehiculoId)
                .orElseThrow(()->new Exception("vehiculo con ID" +vehiculoId+"no encontrado"));

        vehiculoRepository.deleteById(vehiculoId);
    }
}
