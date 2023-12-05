package umc.spring.converter;

import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {
    public static ReviewEntity toReview(RestaurantRequestDTO.ReviewDTO request){
        return ReviewEntity.builder()
                .title(request.getTitle())
                .star(request.getScore())
                .content(request.getBody())
                .build();
    }

    public static RestaurantEntity toRestaurant(RestaurantRequestDTO.RegisterDTO request){
        return RestaurantEntity.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static RestaurantResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(ReviewEntity review){
        return RestaurantResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static RestaurantResponseDTO.CreateRegisterResultDTO toCreateRegisterResultDTO(RestaurantEntity restaurant){
        return RestaurantResponseDTO.CreateRegisterResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
