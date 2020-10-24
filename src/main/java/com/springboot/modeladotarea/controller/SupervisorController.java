package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Supervisor;
import com.springboot.modeladotarea.service.ISupervisorService;

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
@RequestMapping("/supervisores")
public class SupervisorController {
    
    @Autowired
    private ISupervisorService service;

    @GetMapping
    public ResponseEntity<List<Supervisor>> listar(){
       return  new ResponseEntity<List<Supervisor>>(service.listar(),HttpStatus.OK); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supervisor> listarPorId(@PathVariable("id") Integer id){
        Supervisor obj = service.leerPorId(id);
        if(obj.getIdsupervisor() == null){
            throw new ModeloNotFoundException(" EL ID NO HA SIDO ENCONTRADO " + id);
        }

        return new ResponseEntity<Supervisor>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Supervisor supervisor){
        Supervisor obj = service.registrar(supervisor);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdsupervisor()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @PutMapping
    public ResponseEntity<Supervisor> modificar(@Valid @RequestBody Supervisor supervisor){
        Supervisor obj = service.modificar(supervisor);
        return new ResponseEntity<Supervisor>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Supervisor supervisor = service.leerPorId(id);
        if (supervisor.getIdsupervisor() == null) {
            throw new ModeloNotFoundException(" EL ID A ELIMINAR NO EXISTE " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
