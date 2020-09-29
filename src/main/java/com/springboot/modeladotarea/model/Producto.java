package com.springboot.modeladotarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    private Integer idproducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre;

    @Column(name = "descripcion_producto", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_marca", foreignKey = @ForeignKey(name = "FK_prooducto_marca"))
    private Marca marca;

    @Column(name = "valor_producto", nullable = false)
    private Float valor;

 
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (idproducto == null) {
            if (other.idproducto != null)
                return false;
        } else if (!idproducto.equals(other.idproducto))
            return false;
        return true;
    }

    

}
