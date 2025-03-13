package com.leo.crud.vendas.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(){
        super("Resource Not Found");
    }

    public ResourceNotFound(String msg){
        super(msg);
    }

}
