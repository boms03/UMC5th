package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategoryEntity;

import java.util.Optional;

public interface FoodCategoryRepository extends JpaRepository<FoodCategoryEntity,Long> {
    Optional<FoodCategoryEntity> findById(Long id);
}
