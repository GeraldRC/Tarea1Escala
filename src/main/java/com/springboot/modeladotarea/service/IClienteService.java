package com.springboot.modeladotarea.service;

import com.springboot.modeladotarea.model.Cliente;

import org.springframework.stereotype.Service;

@Service
public interface IClienteService extends ICRUD<Cliente, Integer> {
    
}
