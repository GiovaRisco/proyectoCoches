package com.project.coches.exception;

public class CustomerExistException extends RuntimeException {


    public CustomerExistException() {
        super("El usuario ingresado ya existe.");
    }
}
