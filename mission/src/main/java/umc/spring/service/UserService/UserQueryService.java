package umc.spring.service.UserService;

import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.UserEntity;

import java.util.Optional;

public interface UserQueryService {
    Optional<UserEntity> findUser(Long id);
}
