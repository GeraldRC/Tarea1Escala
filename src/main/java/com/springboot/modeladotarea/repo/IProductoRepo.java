package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer> {
    
}
