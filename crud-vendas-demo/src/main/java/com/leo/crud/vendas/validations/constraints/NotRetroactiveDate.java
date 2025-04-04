package com.leo.crud.vendas.validations.constraints;


import com.leo.crud.vendas.validations.NotRetroactiveDateValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotRetroactiveDateValidation.class)
public @interface NotRetroactiveDate {

    String message() default "date cannot be less than the current date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
