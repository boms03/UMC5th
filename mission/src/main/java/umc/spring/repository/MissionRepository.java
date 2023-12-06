package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MissionEntity;

public interface MissionRepository extends JpaRepository<MissionEntity,Long> {
}
