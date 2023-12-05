package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPaylod.code.status.ErrorStatus;
import umc.spring.apiPaylod.exception.handler.FoodCategoryHandler;
import umc.spring.converter.UserConverter;
import umc.spring.converter.UserPreferConverter;
import umc.spring.domain.FoodCategoryEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.mapping.UserPreferEntity;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional()
public class UserCommandServiceImpl implements UserCommandService{
    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public UserEntity joinMember(UserRequestDTO.JoinDto request) {
        UserEntity newUser = UserConverter.toUserEntity(request);

        //id가 저장된 request의 preferCategory 내용을 스트림으로 읽어드려 entity르 찾고 list에 담는다.
        List<FoodCategoryEntity>foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(()-> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<UserPreferEntity> userPreferList = UserPreferConverter.toUserPreferEntityList(foodCategoryList);

        userPreferList.forEach(userPreferEntity -> {userPreferEntity.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
