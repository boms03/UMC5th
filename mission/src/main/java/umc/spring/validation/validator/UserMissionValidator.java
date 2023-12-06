package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.validation.annotation.ExistUserMission;
import umc.spring.web.dto.UserRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserMissionValidator implements ConstraintValidator<ExistUserMission, UserRequestDTO.MissionDTO> {

    private final UserQueryService userQueryService;

    @Override
    public void initialize(ExistUserMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserRequestDTO.MissionDTO value, ConstraintValidatorContext context) {
        Optional<UserMissionEntity> userMission = userQueryService.findUserMission(value.getUserId(), value.getMissionId());
        if(!userMission.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_MISSION_ALREADY_EXIST.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
