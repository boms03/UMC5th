package umc.spring.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "restaurant")
public class RestaurantEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String name;

    @Column(length =50, nullable = false)
    private String address;

    private LocalDateTime unregisteredAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;

}
