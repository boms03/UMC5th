package umc.spring.service.RestaurantService;

import umc.spring.domain.RestaurantEntity;

import java.util.Optional;

public interface RestaurantQueryService {
    Optional<RestaurantEntity> findRestaurant(Long id);
}
