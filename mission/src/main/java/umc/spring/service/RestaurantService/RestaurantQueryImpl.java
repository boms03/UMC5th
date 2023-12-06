package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantQueryImpl implements  RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;

    private final ReviewRepository reviewRepository;
    @Override
    public Optional<RestaurantEntity> findRestaurant(Long id){
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<ReviewEntity> getReviewList(Long restaurantId, Integer page) {
        RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).get();

        Page<ReviewEntity> StorePage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
        return StorePage;
    }


}
