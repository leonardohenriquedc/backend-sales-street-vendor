package com.leo.crud.vendas.exceptions;

public class NotExistsResources extends RuntimeException{

    public NotExistsResources(String msg){
        super(msg);
    }

    public NotExistsResources(){
        super("Não há recursos nessa consulta");
    }
}
