package com.leo.crud.vendas.dto.errors;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ParameterErrors extends CustomError{
    List<FieldError> errors = new ArrayList<>();

    public ParameterErrors(Instant timestamp, Integer status, String error, String path, List<FieldError> errors) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public ParameterErrors(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }

    public ParameterErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public void addErrors(FieldError fieldError){
        errors.add(fieldError);
    }

    public void addErrors(String fieldName, String message){
        errors.add(new FieldError(fieldName, message));
    }
}
