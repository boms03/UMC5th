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

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MissionEntity> missionList = new ArrayList<>();

}
