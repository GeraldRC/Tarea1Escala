package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepo extends JpaRepository<Marca, Integer> {
    
}
