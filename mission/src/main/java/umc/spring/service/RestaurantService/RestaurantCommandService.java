package umc.spring.service.RestaurantService;

import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {
    RestaurantEntity register(RestaurantRequestDTO.RegisterDTO request);
    ReviewEntity createReview(Long userId, Long storeId, RestaurantRequestDTO.ReviewDTO request);

}
