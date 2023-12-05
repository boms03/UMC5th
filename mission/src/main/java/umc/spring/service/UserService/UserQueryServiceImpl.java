package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import umc.spring.domain.RestaurantEntity;
import umc.spring.domain.UserEntity;
import umc.spring.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{
    private final UserRepository userRepository;
    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userRepository.findById(id);
    }

    ;
}
