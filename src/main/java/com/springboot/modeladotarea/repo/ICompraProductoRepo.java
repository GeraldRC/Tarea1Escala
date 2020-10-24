package com.springboot.modeladotarea.repo;

import com.springboot.modeladotarea.model.CompraProducto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompraProductoRepo extends JpaRepository<CompraProducto, Integer> {
    
	@Modifying
	@Query(value = "INSERT INTO compra_producto(id_producto, id_venta) VALUES (:idProducto, :idVenta)" ,nativeQuery = true)
	Integer registrar(@Param("idProducto") Integer idProducto, @Param("idVenta") Integer idVenta);
	
	@Query("from CompraProducto cp where cp.venta.idVenta = :idVenta")
	List<CompraProducto> listarProductosPorVenta(@Param("idVenta") Integer idVenta);
}
