package com.springboot.modeladotarea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.modeladotarea.model.CompraProducto;
import com.springboot.modeladotarea.repo.ICompraProductoRepo;
import com.springboot.modeladotarea.service.ICompraProductoService;

@Service
public class CompraProductoServiceImpl implements ICompraProductoService{
	
	@Autowired
	private ICompraProductoRepo repo;

	@Override
	public List<CompraProducto> listarProductosPorVenta(Integer idVenta) {
		return repo.listarProductosPorVenta(idVenta);
	}
    
}
