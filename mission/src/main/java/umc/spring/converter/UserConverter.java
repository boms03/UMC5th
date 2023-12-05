package umc.spring.converter;

import umc.spring.domain.UserEntity;
import umc.spring.domain.enums.UserGender;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(UserEntity user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserEntity toUserEntity(UserRequestDTO.JoinDto request){
        UserGender gender = null;

        switch (request.getGender()){
            case 1:
                gender = UserGender.MALE;
                break;
            case 2:
                gender = UserGender.FEMALE;
                break;
            case 3:
                gender = UserGender.NONE;
                break;
        }

        return UserEntity.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .name(request.getName())
                .userPreferEntityList(new ArrayList<>())
                .gender(gender)
                .build();
    }
}
