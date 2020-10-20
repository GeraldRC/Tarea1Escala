package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepo extends JpaRepository<Venta, Integer> {
    
}
