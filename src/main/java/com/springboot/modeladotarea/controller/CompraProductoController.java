package com.springboot.modeladotarea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.modeladotarea.model.CompraProducto;
import com.springboot.modeladotarea.service.ICompraProductoService;

@RestController
@RequestMapping("/productosventa")
public class CompraProductoController {
	
	@Autowired
	private ICompraProductoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<CompraProducto>> listarProductosPorVenta(@PathVariable("id") Integer id){
		return new ResponseEntity<List<CompraProducto>>(service.listarProductosPorVenta(id),HttpStatus.OK);
	}

}
