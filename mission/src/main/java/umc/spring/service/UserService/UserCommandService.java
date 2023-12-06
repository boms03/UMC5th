package umc.spring.service.UserService;

import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.web.dto.UserRequestDTO;

public interface UserCommandService {
    UserEntity joinMember(UserRequestDTO.JoinDto request);
    UserMissionEntity addMission(UserRequestDTO.MissionDTO request);
}
