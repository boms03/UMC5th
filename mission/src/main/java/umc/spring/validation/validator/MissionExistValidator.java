package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.domain.MissionEntity;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.web.dto.UserRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistMission, UserRequestDTO.MissionDTO> {

    private final MissionQueryService missionQueryService;

    @Override
    public boolean isValid(UserRequestDTO.MissionDTO value, ConstraintValidatorContext context) {
        Optional<MissionEntity> target = missionQueryService.findMission(value.getMissionId());
        if(target.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
