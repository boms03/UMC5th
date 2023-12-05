package umc.spring.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "restaurant_category")
public class RestaurantCategoryEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String name;

    @Column(length =50, nullable = false)
    private String address;

    private LocalDateTime unregisteredAt;

}
