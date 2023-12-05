package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.RegionEntity;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.RestaurantRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.RestaurantRequestDTO;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final RestaurantRepository restaurantRepository;

    private final RegionRepository regionRepository;

    @Override
    public RestaurantEntity register(RestaurantRequestDTO.RegisterDTO request) {

        RestaurantEntity restaurant = RestaurantConverter.toRestaurant(request);
        restaurant.setRegion(regionRepository.findByName(request.getAddress()).get());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public ReviewEntity createReview(Long userId, Long restaurantId, RestaurantRequestDTO.ReviewDTO request) {
        ReviewEntity review = RestaurantConverter.toReview(request);
        review.setUser(userRepository.findById(userId).get());
        review.setRestaurant(restaurantRepository.findById(restaurantId).get());

        return reviewRepository.save(review);
    }
}
