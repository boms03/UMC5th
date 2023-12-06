package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.web.dto.RestaurantRequestDTO;
import umc.spring.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(ReviewEntity review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getStar())
                .createdAt(review.getRegisteredAt().toLocalDate())
                .body(review.getContent())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<ReviewEntity> reviewList){
        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(RestaurantConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

}
