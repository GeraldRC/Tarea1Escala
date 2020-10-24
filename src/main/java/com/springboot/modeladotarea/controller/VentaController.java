package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Venta;
import com.springboot.modeladotarea.service.IVentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    
    @Autowired
    private IVentaService service;

    @GetMapping
    public ResponseEntity<List<Venta>> listar(){
        return new ResponseEntity<List<Venta>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id){
        Venta venta = service.leerPorId(id);
        if (venta.getIdVenta() == null) {
            throw new ModeloNotFoundException(" EL ID NO HA SIDO ENCONTRADO " + id);
        }
        return new ResponseEntity<Venta>(venta,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Venta venta){
        Venta obj = service.registrar(venta);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @PutMapping
    public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta){
        Venta obj = service.modificar(venta);
        return new ResponseEntity<Venta>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("/{id}") Integer id){
        Venta venta = service.leerPorId(id);
        if (venta.getIdVenta() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO "+ id);
        }
        service.eliminar(id);
         return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
