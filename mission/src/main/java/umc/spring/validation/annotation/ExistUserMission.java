package umc.spring.validation.annotation;

import umc.spring.validation.validator.UserExistValidator;
import umc.spring.validation.validator.UserMissionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserMissionValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUserMission {

    String message() default "해당하는 미션은 이미 도전 중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
