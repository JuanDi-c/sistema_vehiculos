package com.juan.proyecto_apis.service;

import com.juan.proyecto_apis.entity.Conductor;
import java.util.List;

public interface ConductorService {
    List<Conductor> listConductores();//mostrar

    Conductor registerConductor(Conductor conductor);//agregar

    Conductor updateConductor(Long idConductor, Conductor conductor);

    void deleteConductor(Long idConductor);
}
