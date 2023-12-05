package umc.spring.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.RestaurantEntity;
import umc.spring.repository.RestaurantRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantQueryImpl implements  RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    @Override
    public Optional<RestaurantEntity> findRestaurant(Long id){
        return restaurantRepository.findById(id);
    }
}
