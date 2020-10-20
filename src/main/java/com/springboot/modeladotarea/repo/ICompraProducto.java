package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.CompraProducto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraProducto extends JpaRepository<CompraProducto, Integer> {
    
}
