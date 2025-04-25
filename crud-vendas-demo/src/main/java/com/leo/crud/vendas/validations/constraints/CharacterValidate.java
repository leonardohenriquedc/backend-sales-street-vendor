package com.leo.crud.vendas.validations.constraints;

import com.leo.crud.vendas.validations.CharacterValidateValidation;
import com.leo.crud.vendas.validations.DateNotExceedingValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CharacterValidateValidation.class)
public @interface CharacterValidate {
    String message() default "Invalid String";

    String characters() default "";

    int initial() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
