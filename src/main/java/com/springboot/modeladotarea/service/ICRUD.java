package com.springboot.modeladotarea.service;

import java.util.List;

public interface ICRUD<T,ID> {

    T registrar(T obj);
    T modificar(T obj);
    List<T> listar();
    T leerPorId(ID id);
    boolean eliminar(ID id);
    
}
