package umc.spring.repository;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<UserMissionEntity, Long> {
    Optional<UserMissionEntity>findByUserIdAndMissionId(Long userId, Long missionId);

    Page<UserMissionEntity> findAllByUser(UserEntity user, PageRequest of);
}
