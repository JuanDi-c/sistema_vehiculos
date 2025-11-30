package com.juan.proyecto_apis.service;

import com.juan.proyecto_apis.entity.Seguro;

import java.util.List;

public interface SeguroService {
    List<Seguro> listSeguros();//mostrar

    Seguro registerSeguro(Seguro seguro);//agregar

    Seguro updateSeguro(String idSeguro,Seguro seguro);

    void deleteSeguro(String idSeguro);

}
