package com.springboot.modeladotarea.service.impl;

import java.util.List;
import java.util.Optional;

import com.springboot.modeladotarea.model.Producto;
import com.springboot.modeladotarea.repo.IProductoRepo;
import com.springboot.modeladotarea.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepo repo;

    @Override
    public Producto registrar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public Producto modificar(Producto obj) {
        return repo.save(obj);
    }

    @Override
    public List<Producto> listar() {
        return repo.findAll();
    }

    @Override
    public Producto leerPorId(Integer id) {
        Optional<Producto> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Producto();
    }

    @Override
    public boolean eliminar(Integer id) {
        repo.deleteById(id);
        return true;
    }
    
}
