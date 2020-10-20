package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVendedorRepo extends JpaRepository<Vendedor, Integer> {
    
}
