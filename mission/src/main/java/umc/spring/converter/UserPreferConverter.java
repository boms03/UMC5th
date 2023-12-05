package umc.spring.converter;

import umc.spring.domain.FoodCategoryEntity;
import umc.spring.domain.mapping.UserPreferEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPreferEntity> toUserPreferEntityList(List<FoodCategoryEntity> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategoryEntity ->
                        UserPreferEntity.builder()
                                .foodCategory(foodCategoryEntity)
                                .build()
                ).collect(Collectors.toList());
    }
}
