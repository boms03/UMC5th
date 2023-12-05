package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.UserGender;
import umc.spring.domain.enums.UserStatus;
import umc.spring.domain.mapping.UserAgreeTermEntity;
import umc.spring.domain.mapping.UserPreferEntity;
import umc.spring.domain.mapping.UserMissionEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@DynamicInsert
@Builder
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(length =20, nullable = false)
    private String name;

    @Column(length =20, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserGender gender;

//    @Column(length =20, nullable = false)
    private String email;

    @Column(length =50, nullable = false)
    private String address;

    @Column(length =50, nullable = false)
    private String specAddress;

    @ColumnDefault("0")
    private Integer point;

    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserAgreeTermEntity> userAgreeTermEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserPreferEntity> userPreferEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMissionEntity> userMissionEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewEntity> reviewEntityList = new ArrayList<>();

}
