package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    Page<ReviewEntity> findAllByRestaurant(RestaurantEntity restaurant, PageRequest of);

    Page<ReviewEntity> findAllByUser(UserEntity user, PageRequest of);
}
