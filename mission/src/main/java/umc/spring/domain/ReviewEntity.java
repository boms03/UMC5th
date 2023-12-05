package umc.spring.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "review")
public class ReviewEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String title;

    @Column(length =20, nullable = false)
    private Float star;

    @Column(length =50, nullable = false)
    private String content;

    private LocalDateTime unregisteredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImageEntity> reviewImageEntityList = new ArrayList<>();

    public void setUser(UserEntity user){
        if(this.user != null)
            user.getReviewEntityList().remove(this);
        this.user = user;
        user.getReviewEntityList().add(this);
    }

    public void setStore(RestaurantEntity restaurant){
        if (this.star != null)
            restaurant.getReviewEntityList().remove(this);
        this.restaurant = restaurant;
        restaurant.getReviewEntityList().add(this);
    }

}