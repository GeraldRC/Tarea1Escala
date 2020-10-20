package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Vendedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendedorRepo extends JpaRepository<Vendedor, Integer> {
    
}
