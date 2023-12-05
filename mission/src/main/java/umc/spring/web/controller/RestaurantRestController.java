package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPaylod.ApiResponse;
import umc.spring.converter.RestaurantConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.service.RestaurantService.RestaurantCommandService;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantCommandService restaurantCommandService;

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

            @PathVariable(name="restaurantID")
            Long restaurantID,

            @RequestParam(name="userId")
            Long userId
    ){
        ReviewEntity review = restaurantCommandService.createReview(userId, restaurantID, request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateReviewResultDTO(review));
    }
}
