package com.springboot.modeladotarea.service.impl;

import java.util.List;
import java.util.Optional;

import com.springboot.modeladotarea.model.Cliente;
import com.springboot.modeladotarea.repo.IClienteRepo;
import com.springboot.modeladotarea.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteRepo repo;

    @Override
    public Cliente registrar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public Cliente modificar(Cliente obj) {
        return repo.save(obj);
    }

    @Override
    public List<Cliente> listar() {
        return repo.findAll();
    }

    @Override
    public Cliente leerPorId(Integer id) {
        Optional<Cliente> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Cliente();
    }

    @Override
    public boolean eliminar(Integer id) {
        boolean res = false;
        Optional<Cliente> op = repo.findById(id);

        if (op.isPresent()) {
            repo.deleteById(id);
            res = true;
        }
        return res;
    }

}
