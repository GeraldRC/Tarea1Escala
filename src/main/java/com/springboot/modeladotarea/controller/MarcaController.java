package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Marca;
import com.springboot.modeladotarea.service.IMarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/marcas")
public class MarcaController {
    
    @Autowired
    private IMarcaService service;


    @GetMapping
    public ResponseEntity<List<Marca>> listar(){
        return new ResponseEntity<List<Marca>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> listarPorId(@PathVariable("id") Integer id){
        Marca marca = service.leerPorId(id);
        if (marca.getIdmarca() == null) {
            throw new ModeloNotFoundException("NO HA SIDO ECONTRADO EL ID " + id);
        }
        return new ResponseEntity<Marca>(marca,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Marca marca){
        Marca obj = service.registrar(marca);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdmarca()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @PutMapping
    public ResponseEntity<Marca> modificar(@Valid @RequestBody Marca marca){
        Marca obj = service.modificar(marca);
        return new ResponseEntity<Marca>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Marca obj = service.leerPorId(id);
        if (obj.getIdmarca() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO "+ id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
}