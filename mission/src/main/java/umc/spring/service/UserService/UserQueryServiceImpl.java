package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.repository.UserMissionRepository;
import umc.spring.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserMissionEntity> findUserMission(Long userId, Long missionId) {

        return userMissionRepository.findByUserIdAndMissionId(userId,missionId);

    }



    ;
}
