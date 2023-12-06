package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.enums.UserGender;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.web.dto.RestaurantResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static UserResponseDTO.ReviewPreViewDTO reviewPreViewDTO(ReviewEntity review){
        return UserResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getStar())
                .createdAt(review.getRegisteredAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static UserResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<ReviewEntity> reviewList){
        List<UserResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static UserResponseDTO.MissionDTO missionViewDTO(UserMissionEntity userMission){
        return UserResponseDTO.MissionDTO.builder()
                .ownerNickname(userMission.getUser().getName())
                .reward(userMission.getMission().getReward())
                .createdAt(userMission.getRegisteredAt().toLocalDate())
                .body(userMission.getMission().getContent())
                .build();
    }
    public static UserResponseDTO.MissionListDTO missionViewListDTO(Page<UserMissionEntity> missionList){
        List<UserResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(UserConverter::missionViewDTO).collect(Collectors.toList());

        return UserResponseDTO.MissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionDTOList.size())
                .missionList(missionDTOList)
                .build();
    }
}
