package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepo extends JpaRepository<Venta, Integer> {
    
}
