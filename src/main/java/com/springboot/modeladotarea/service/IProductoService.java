package com.springboot.modeladotarea.service;

import com.springboot.modeladotarea.model.Producto;

import org.springframework.stereotype.Service;

@Service
public interface IProductoService extends ICRUD<Producto, Integer> {
    
}
