package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.FoodCategoryEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "user_favourite_food_category")
public class UserFavouriteFoodCategoryEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategory;
}
