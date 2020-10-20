package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepo extends JpaRepository<Cliente,Integer> {
    
}
