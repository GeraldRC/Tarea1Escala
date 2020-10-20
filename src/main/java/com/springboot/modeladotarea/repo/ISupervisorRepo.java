package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.Supervisor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupervisorRepo extends JpaRepository<Supervisor, Integer> {


}