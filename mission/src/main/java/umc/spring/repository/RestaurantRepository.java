package umc.spring.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import umc.spring.domain.RestaurantEntity;

import javax.transaction.Transactional;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long> {
}
