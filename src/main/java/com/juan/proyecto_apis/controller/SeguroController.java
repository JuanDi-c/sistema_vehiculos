package com.juan.proyecto_apis.controller;

import com.juan.proyecto_apis.entity.Seguro;
import com.juan.proyecto_apis.entity.Vehiculo;
import com.juan.proyecto_apis.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguros")
public class SeguroController {
    @Autowired
    private SeguroService seguroService;

    @GetMapping("/list")
    public ResponseEntity<List<Seguro>> listSeguro(){
        List<Seguro> seguros = seguroService.listSeguros();
        return ResponseEntity.ok(seguros);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerSeguro(@RequestBody Seguro seguro){
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }

    @PutMapping("/update/{idSeguro}")
    public ResponseEntity<?> updateSeguro(@PathVariable String idSeguro, @RequestBody Seguro seguro){
        try{
            Seguro updateSeguro = new Seguro();
            updateSeguro.setIdSeguro(seguro.getIdSeguro());
            updateSeguro.setCompSeguro(seguro.getCompSeguro());
            updateSeguro.setPolSeguro(seguro.getPolSeguro());
            updateSeguro.setFiniSeguro(seguro.getFiniSeguro());
            updateSeguro.setFvenSeguro(seguro.getFvenSeguro());

            Seguro seguroDB = seguroService.updateSeguro(idSeguro, seguro);
            return ResponseEntity.ok(seguroDB);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idSeguro}")
    public ResponseEntity<?> deleteSeguro(@PathVariable String idSeguro){
        try{
            seguroService.deleteSeguro(idSeguro);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/search/by/vehiculo/{vehiculo}")
    public ResponseEntity<List<Seguro>> searchSegurosByvehiculoId(@PathVariable Vehiculo vehiculo) {
        List<Seguro> seguros = seguroService.getSegurosByvehiculoId(vehiculo);
        return ResponseEntity.ok(seguros);
    }

}
