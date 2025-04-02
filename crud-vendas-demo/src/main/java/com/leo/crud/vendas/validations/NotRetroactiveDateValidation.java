package com.leo.crud.vendas.validations;

import com.leo.crud.vendas.validations.constraints.NotRetroactiveDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class NotRetroactiveDateValidation implements ConstraintValidator<NotRetroactiveDate, LocalDate> {
    @Override
    public void initialize(NotRetroactiveDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {

        System.out.println("Validando data: " + date);

        LocalDate dateNow = LocalDate.now();

        if(date == null) return false;

        return !date.isBefore(dateNow);
    }
}
