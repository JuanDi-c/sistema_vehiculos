package com.juan.proyecto_apis.controller;

import com.juan.proyecto_apis.entity.Vehiculo;
import com.juan.proyecto_apis.repository.VehiculoRepository;
import com.juan.proyecto_apis.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/register")
    public ResponseEntity<?> registerVehiculo(@RequestBody Vehiculo vehiculo){

        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> ListVehiculos(){
        List<Vehiculo> vehiculos = vehiculoService.ListVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @PutMapping("/update/{vehiculoId}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long vehiculoId , @RequestBody Vehiculo vehiculo ) {
        try{
            Vehiculo updateVehiculo = new Vehiculo();
            updateVehiculo.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
            updateVehiculo.setVehiculoMarca(vehiculo.getVehiculoMarca());
            updateVehiculo.setVehiculoModelo(vehiculo.getVehiculoModelo());
            updateVehiculo.setVehiculoAno(vehiculo.getVehiculoAno());
            updateVehiculo.setVehiculoColor(vehiculo.getVehiculoColor());

            Vehiculo vehiculoDB = vehiculoService.updateVehiculo(vehiculoId, updateVehiculo);
            return ResponseEntity.ok(vehiculoDB);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{vehiculoId}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long vehiculoId) {
        try{
            vehiculoService.deleteVehiculo(vehiculoId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }


}
