package com.leo.crud.vendas.validations;

import com.leo.crud.vendas.validations.constraints.CharacterValidate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CharacterValidateValidation implements ConstraintValidator<CharacterValidate, String> {

    private String character;

    private int initial;

    @Override
    public void initialize(CharacterValidate constraintAnnotation) {
        this.character = constraintAnnotation.characters();
        this.initial = constraintAnnotation.initial();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return false;

        if (initial >= s.length()) {
            return false;
        }

        StringBuilder word = new StringBuilder();

        for(int num = 0; num <= character.length(); num++){

            if(s.startsWith(word.toString(), initial)) return true;

            word.append(character.charAt(num));
        }

        return false;
    }
}
