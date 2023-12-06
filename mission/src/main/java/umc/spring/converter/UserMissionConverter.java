package umc.spring.converter;

import umc.spring.domain.MissionEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.enums.UserMissionStatus;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserMissionConverter {
    public static UserMissionEntity toUserMissionEntity(UserEntity user, MissionEntity mission){
        return UserMissionEntity.builder()
                .user(user)
                .mission(mission)
                .status(UserMissionStatus.PROCEEDING)
                .build();
    }

    public static UserResponseDTO.AddMissionResultDTO toAddMissionDTO(UserMissionEntity userMission){
        return UserResponseDTO.AddMissionResultDTO.builder()
                .missionId(userMission.getUser().getId())
                .userId(userMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


}
