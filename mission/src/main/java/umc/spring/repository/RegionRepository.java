package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.RegionEntity;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<RegionEntity,Long> {

    Optional<RegionEntity> findByName(String name);
}
