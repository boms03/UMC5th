package umc.spring.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.mapping.UserMissionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Entity
@Table(name = "mission")
public class MissionEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String title;

    @Column(length =20, nullable = false)
    private String content;

    private Integer reward;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMissionEntity> userMissionEntityList = new ArrayList<>();

}
