package com.springboot.modeladotarea.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.springboot.modeladotarea.exception.ModeloNotFoundException;
import com.springboot.modeladotarea.model.Producto;
import com.springboot.modeladotarea.service.IProductoService;

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
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;


    @GetMapping
    public ResponseEntity<List<Producto>> listar(){
        return new ResponseEntity<List<Producto>>(service.listar(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id){
        Producto marca = service.leerPorId(id);
        if (marca.getIdproducto() == null) {
            throw new ModeloNotFoundException("EL ID NO HA SIDO ENCONTRADO ".concat(String.valueOf(id)));
        }
        return new ResponseEntity<Producto>(marca,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@Valid @RequestBody Producto producto){
        Producto obj = service.registrar(producto);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdproducto()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto){
        Producto obj = service.modificar(producto);
        return new ResponseEntity<Producto>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Producto obj = service.leerPorId(id);
        if (obj.getIdproducto() == null) {
            throw new ModeloNotFoundException(" EL ID NO SE ENCONTRO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}