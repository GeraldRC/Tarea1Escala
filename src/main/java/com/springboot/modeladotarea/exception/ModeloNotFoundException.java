package com.springboot.modeladotarea.exception;

public class ModeloNotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public ModeloNotFoundException(String message){
        super(message);
    }
}
 
     