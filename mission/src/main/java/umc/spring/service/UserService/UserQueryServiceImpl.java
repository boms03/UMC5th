package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.spring.domain.MissionEntity;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.ReviewEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserMissionEntity;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserMissionRepository;
import umc.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{

    private final UserRepository userRepository;
    private final UserMissionRepository userMissionRepository;
    private final ReviewRepository reviewRepository;
    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserMissionEntity> findUserMission(Long userId, Long missionId) {

        return userMissionRepository.findByUserIdAndMissionId(userId,missionId);

    }

    @Override
    public Page<ReviewEntity> getReviewList(Long userId, Integer page) {
        UserEntity user = userRepository.findById(userId).get();

        Page<ReviewEntity> StorePage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return StorePage;
    }

    @Override
    public Page<UserMissionEntity> getUserMissionList(Long userId, Integer page) {
        UserEntity user = userRepository.findById(userId).get();

        Page<UserMissionEntity> StorePage = userMissionRepository.findAllByUser(user, PageRequest.of(page, 10));
        return StorePage;
    }


    ;
}
