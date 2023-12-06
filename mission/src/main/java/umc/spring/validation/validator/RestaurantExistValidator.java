package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.domain.RestaurantEntity;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.ExistUserMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantQueryService restaurantQueryService;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional< RestaurantEntity> target = restaurantQueryService.findRestaurant(value);
        // todo target 검사
        if(target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
