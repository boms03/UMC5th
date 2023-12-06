package umc.spring.web.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPaylod.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserMissionConverter;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.validation.annotation.*;
import umc.spring.web.dto.RestaurantResponseDTO;
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
    private final UserQueryService userQueryService;
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

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "특정 사용자 리뷰 목록 조회 API",description = "특정 사용자 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<UserResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistUser
            @PathVariable(name = "userId")
            Long userId,

            @CheckPage
            @RequestParam(name = "page")
            Integer page
    ) {
        Page<ReviewEntity> list = userQueryService.getReviewList(userId,page);
        return ApiResponse.onSuccess(UserConverter.reviewPreViewListDTO(list));
    }


}
