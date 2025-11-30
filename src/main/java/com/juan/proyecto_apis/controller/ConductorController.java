package com.juan.proyecto_apis.controller;


import com.juan.proyecto_apis.entity.Conductor;
import com.juan.proyecto_apis.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/list")
    public ResponseEntity<List<Conductor>> listConductor(){
        List<Conductor> conductores = conductorService.listConductores();
        return ResponseEntity.ok(conductores);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerConductor(@RequestBody Conductor conductor){
        Conductor newConductor = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConductor);
    }

    @PutMapping("/update/{idConductor}")
    public ResponseEntity<?> updateConductor(@PathVariable Long idConductor, @RequestBody Conductor conductor){
        try{
            Conductor updateConductor = new Conductor();
            updateConductor.setNombreConductor(conductor.getNombreConductor());
            updateConductor.setLicenciaConductor(conductor.getLicenciaConductor());
            updateConductor.setTelefonoConductor(conductor.getTelefonoConductor());
            updateConductor.setDireccionConductor(conductor.getDireccionConductor());
            updateConductor.setConductorState(conductor.getConductorState());

            Conductor conductorDB = conductorService.updateConductor(idConductor, conductor);
            return ResponseEntity.ok(conductorDB);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idConductor}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long idConductor){
        try{
            conductorService.deleteConductor(idConductor);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }


}