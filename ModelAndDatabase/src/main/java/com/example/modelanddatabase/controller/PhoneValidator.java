package com.example.modelanddatabase.controller;

import com.example.modelanddatabase.vo.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements  ConstraintValidator<Phone, String>{
    private boolean onlyNumber = false;

    @Override
    public void initialize(Phone phone) {
        //하이픈(-) 없이 번호만으로 유효성 확인
        onlyNumber = phone.onlyNumber();

    }

    @Override
    public boolean isValid(String input, ConstraintValidatorContext cxt) {
        //하이픈(-) 없이 번호만으로 유효성 확인
        if (input == null) {
            return false;
        }
        if (onlyNumber) {
            return input.matches("[0-9()]*");
        } else {
            return input.matches("[0-9()-]*");
        }


//        if (input == null) {
//            return false;
//        }
//        return input.matches("[0-9()-]*");
    }
}
