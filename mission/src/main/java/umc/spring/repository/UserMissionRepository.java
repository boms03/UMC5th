package umc.spring.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.UserMissionEntity;

public interface UserMissionRepository extends JpaRepository<UserMissionEntity, Long> {
}
