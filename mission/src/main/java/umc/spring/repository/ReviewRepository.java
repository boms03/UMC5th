package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.ReviewEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
}
