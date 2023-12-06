package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MissionEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;

public interface MissionRepository extends JpaRepository<MissionEntity,Long> {
}
