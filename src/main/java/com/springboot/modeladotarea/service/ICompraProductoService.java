package com.springboot.modeladotarea.service;

import java.util.List;

import com.springboot.modeladotarea.model.CompraProducto;

public interface ICompraProductoService {
	
	List<CompraProducto> listarProductosPorVenta(Integer idVenta);
	
}
