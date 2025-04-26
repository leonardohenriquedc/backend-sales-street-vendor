package com.leo.crud.vendas.exceptions;

public class ResourceAlreadyExists extends RuntimeException{
    public ResourceAlreadyExists(String msg){
        super(msg);
    }

    public ResourceAlreadyExists(){
        super("Resource already exists");
    }
}
