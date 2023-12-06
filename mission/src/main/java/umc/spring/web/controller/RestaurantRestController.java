package umc.spring.web.controller;

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
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.service.RestaurantService.RestaurantQueryService;
import umc.spring.validation.annotation.ExistRestaurant;
import umc.spring.validation.annotation.ExistUser;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/restaurants")
@Validated
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;
    private final RestaurantQueryService restaurantQueryService;
    @PostMapping("/register")
    public ApiResponse<RestaurantResponseDTO.CreateRegisterResultDTO> register(
            @RequestBody
            @Valid
            RestaurantRequestDTO.RegisterDTO request
    ){
        RestaurantEntity restaurant = restaurantCommandService.register(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateRegisterResultDTO(restaurant));
    }

    @PostMapping("/{restaurantID}/reviews")
    public ApiResponse<RestaurantResponseDTO.CreateReviewResultDTO> createReview(
            @RequestBody
            @Valid
            RestaurantRequestDTO.ReviewDTO request,

            @ExistRestaurant
            @PathVariable(name="restaurantID")
            Long restaurantID,

            @ExistUser
            @RequestParam(name="userId")
            Long userId
    ){
        ReviewEntity review = restaurantCommandService.createReview(userId, restaurantID, request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateReviewResultDTO(review));
    }

    @GetMapping("/{restaurantId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "restaurantId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다.")
    })
    public ApiResponse<RestaurantResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistRestaurant
            @PathVariable(name = "restaurantId")
            Long restaurantId, @RequestParam(name = "page") Integer page
    ) {
        Page<ReviewEntity> list = restaurantQueryService.getReviewList(restaurantId,page);
        return ApiResponse.onSuccess(RestaurantConverter.reviewPreViewListDTO(list));
    }


}
