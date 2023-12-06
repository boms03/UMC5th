package umc.spring.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<RestaurantEntity> findRestaurant(Long id);

    Page<ReviewEntity> getReviewList(Long restaurantId, Integer page);
}
