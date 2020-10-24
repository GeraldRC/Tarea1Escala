package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Cliente;
import com.springboot.modeladotarea.service.IClienteService;

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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService service;


    @GetMapping
    public ResponseEntity<List<Cliente>> listar(){
        List<Cliente> clientes = service.listar();
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarPorId(@PathVariable("id") Integer id ){
        Cliente cliente = service.leerPorId(id);
        if (cliente == null) {
            throw new ModeloNotFoundException("EL ID NO FUE ENCONTRADO" + id);
        }

        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Cliente cliente){
        Cliente obj = service.registrar(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdcliente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Cliente> modificar(@Valid @RequestBody Cliente cliente){
        Cliente obj = service.modificar(cliente);
        return new ResponseEntity<Cliente>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Cliente obj = service.leerPorId(id);
        if (obj.getIdcliente() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO" + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
}
