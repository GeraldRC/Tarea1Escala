package com.springboot.modeladotarea.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    
    private LocalDateTime timestap;
    private String mensaje;
    private String detalles;

    public ExceptionResponse(LocalDateTime timestap, String mensaje, String detalles){
        this.timestap = timestap;
        this.mensaje = mensaje;
        this.detalles = detalles;
    }

    public LocalDateTime getTimestap(){
        return timestap;
    }

    public void setTimestap(LocalDateTime timestap){
        this.timestap= timestap;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getDetalles(){
        return detalles;
    }

    public void setDetalle(String detalles){
        this.detalles = detalles;
    }

}
