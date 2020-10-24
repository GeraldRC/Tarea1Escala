package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Vendedor;
import com.springboot.modeladotarea.service.IVendedorService;

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
@RequestMapping("/vendedores")
public class VendedorController {
    
    @Autowired
    private IVendedorService service;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar(){
        return new ResponseEntity<List<Vendedor>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> listarPorId(@PathVariable("id") Integer id){
        Vendedor vendedor = service.leerPorId(id);
        if (vendedor.getIdvendedor() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO " + id);
        }
        return new ResponseEntity<Vendedor>(vendedor,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Vendedor vendedor){
        Vendedor obj = service.registrar(vendedor);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdvendedor()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @PutMapping
    public ResponseEntity<Vendedor> modificar(@Valid @RequestBody Vendedor vendedor){
        Vendedor obj = service.modificar(vendedor);
        return new ResponseEntity<Vendedor>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Vendedor obj = service.leerPorId(id);
        if (obj.getIdvendedor() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
