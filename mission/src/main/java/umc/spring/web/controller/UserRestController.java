package umc.spring.web.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPaylod.ApiResponse;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.validation.annotation.ExistUserMission;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;
    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(
            @RequestBody @Valid UserRequestDTO.JoinDto request
    ){
        UserEntity user = userCommandService.joinMember(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @PostMapping("/add-mission")
    public ApiResponse<UserResponseDTO.AddMissionResultDTO> addMission(
            @RequestBody
            @ExistUserMission
            UserRequestDTO.MissionDTO request
    ){
        UserMissionEntity userMission= userCommandService.addMission(request);
        return ApiResponse.onSuccess(UserMissionConverter.toAddMissionDTO(userMission));
    }


}
