package com.restapinaming.demo.error;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id){
        super("Customer id not found ");
    }
}
