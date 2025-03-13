package com.leo.crud.vendas.exceptions;

public class NotPossibleSave extends RuntimeException{

    public NotPossibleSave(){
        super("not possible save entity");
    }

    public NotPossibleSave(String msg){
        super(msg);
    }
}
