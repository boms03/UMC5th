package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.FoodCategoryEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "user_favourite_food_category")
public class UserPreferEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private FoodCategoryEntity foodCategory;

    public void setUser(UserEntity user){
        if(this.user != null)
            user.getUserPreferEntityList().remove(this);
        this.user = user;
        user.getUserPreferEntityList().add(this);
    }

    public void setFoodCategory(FoodCategoryEntity foodCategory){
        this.foodCategory = foodCategory;
    }
}
