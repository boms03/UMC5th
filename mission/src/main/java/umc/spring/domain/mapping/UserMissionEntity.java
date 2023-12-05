package umc.spring.domain.mapping;


import lombok.*;
import lombok.experimental.SuperBuilder;
import umc.spring.domain.MissionEntity;
import umc.spring.domain.UserEntity;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.UserMissionStatus;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@Table(name = "user_mission")
public class UserMissionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserMissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private MissionEntity mission;
}
