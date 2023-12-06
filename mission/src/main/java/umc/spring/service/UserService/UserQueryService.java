package umc.spring.service.UserService;

import org.springframework.data.domain.Page;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;

import java.util.Optional;

public interface UserQueryService {
    Optional<UserEntity> findUser(Long id);
    Optional<UserMissionEntity> findUserMission(Long userId, Long missionId);

    Page<ReviewEntity> getReviewList(Long userId, Integer page);
}
