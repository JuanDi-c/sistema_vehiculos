package com.juan.proyecto_apis.service;

import com.juan.proyecto_apis.entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehiculoService {

    List<Vehiculo> ListVehiculos();//mostrar

    Vehiculo registerVehiculo(Vehiculo vehiculo);//agregar

    Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo);

    void deleteVehiculo(Long vehiculoId);


}
