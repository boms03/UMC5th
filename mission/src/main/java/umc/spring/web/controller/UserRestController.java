package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPaylod.ApiResponse;
import umc.spring.converter.UserConverter;
import umc.spring.domain.UserEntity;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class UserRestController {
    private final UserCommandService userCommandService;
    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        UserEntity user = userCommandService.joinMember(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

}
