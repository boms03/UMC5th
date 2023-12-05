package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.UserEntity;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.service.UserService.UserQueryServiceImpl;
import umc.spring.validation.annotation.ExistUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUser,Long> {

    private final UserQueryService userQueryService;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<UserEntity> target = userQueryService.findUser(value);
        if(!target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
