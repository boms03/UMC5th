package umc.spring.validation.validator;

import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if(value<0){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE_NUMBER.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
