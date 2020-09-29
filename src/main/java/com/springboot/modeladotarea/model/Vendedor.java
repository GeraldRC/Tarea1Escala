package com.springboot.modeladotarea.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idvendedor;

    @ManyToOne
    @JoinColumn(name = "id_supervisor", foreignKey = @ForeignKey(name = "FK_vendedor_supervisor"))
    private Supervisor supervisor;

    @Column(name = "nombre_vendedor", nullable = false)
    private String nombre;

    @Column(name = "direccion_vendedor")
    private String direccion;

    public Integer getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Integer idvendedor) {
        this.idvendedor = idvendedor;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
