package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends JpaRepository<Cliente,Integer> {
    
}
